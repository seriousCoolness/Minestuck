package com.mraof.minestuck.editmode;

import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.MinestuckConfig;
import com.mraof.minestuck.client.gui.playerStats.PlayerStatsScreen;
import com.mraof.minestuck.client.util.GuiUtil;
import com.mraof.minestuck.item.crafting.alchemy.*;
import com.mraof.minestuck.network.ClientEditPacket;
import com.mraof.minestuck.network.MSPacketHandler;
import com.mraof.minestuck.world.MSDimensions;
import com.mraof.minestuck.world.storage.ClientPlayerData;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Minestuck.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class ClientEditHandler
{
	static boolean activated;
	
	static int centerX, centerZ;
	
	public static String client;
	
	/**
	 * Used to tell if the client is in edit mode or not.
	 */
	public static boolean isActive() {
		return activated;
	}
	
	public static void onKeyPressed()
	{
		ClientEditPacket packet = ClientEditPacket.exit();
		MSPacketHandler.sendToServer(packet);
	}
	
	public static void onClientPackage(String target, int posX, int posZ, CompoundNBT deployList)
	{
		Minecraft mc = Minecraft.getInstance();
		ClientPlayerEntity player = mc.player;
		if(target != null) {	//Enable edit mode
			activated = true;
			centerX = posX;
			centerZ = posZ;
			client = target;
		}
		else if(deployList == null)	//Disable edit mode
		{
			player.fallDistance = 0;
			activated = false;
		}
		if(deployList != null)
		{
			ClientDeployList.load(deployList);
		}
	}
	
	@SubscribeEvent
	public static void addToolTip(ItemTooltipEvent event)
	{
		if(!isActive())
			return;
		
		GristSet have = ClientPlayerData.getClientGrist();
		
		addToolTip(event.getItemStack(), event.getToolTip(), have, event.getEntity().world);
		
	}
	
	private static GristSet itemCost(ItemStack stack, World world)
	{
		ClientDeployList.Entry deployEntry = ClientDeployList.getEntry(stack);
		if(deployEntry != null)
			return deployEntry.getCost();
		else return GristCostRecipe.findCostForItem(stack, null, false, world);
	}
	
	private static void addToolTip(ItemStack stack, List<ITextComponent> toolTip, GristSet have, World world)
	{
		GristSet cost = itemCost(stack, world);
		
		if(cost == null)
		{
			return;
		}
		
		for(GristAmount amount : cost.getAmounts())
		{
			GristType grist = amount.getType();
			TextFormatting color = amount.getAmount() <= have.getGrist(grist) ? TextFormatting.GREEN : TextFormatting.RED;
			toolTip.add(new StringTextComponent(amount.getAmount()+" ").appendSibling(grist.getDisplayName()).appendText(" ("+have.getGrist(grist) + ")").setStyle(new Style().setColor(color)));
		}
		if(cost.isEmpty())
			toolTip.add(new TranslationTextComponent(GuiUtil.FREE).setStyle(new Style().setColor(TextFormatting.GREEN)));
	}
	
	@SubscribeEvent
	public static void tickEnd(TickEvent.PlayerTickEvent event)
	{
		if(event.phase != TickEvent.Phase.END || event.player != Minecraft.getInstance().player || !isActive())
			return;
		PlayerEntity player = event.player;
		
		double range = MSDimensions.isLandDimension(player.dimension) ? MinestuckConfig.landEditRange.get() : MinestuckConfig.overworldEditRange.get();
		
		ServerEditHandler.updatePosition(player, range, centerX, centerZ);
		
	}
	
	@SubscribeEvent
	public static void onTossEvent(ItemTossEvent event)
	{
		if(event.getEntity().world.isRemote && event.getPlayer().isUser() && isActive())
		{
			PlayerInventory inventory = event.getPlayer().inventory;
			ItemStack stack = event.getEntityItem().getItem();
			ClientDeployList.Entry entry = ClientDeployList.getEntry(stack);
			if(entry != null)
			{
				if(ServerEditHandler.isBlockItem(stack.getItem()) || !GristHelper.canAfford(ClientPlayerData.getClientGrist(), entry.getCost()))
					event.setCanceled(true);
			}
			if(event.isCanceled())
			{
				if(!inventory.getItemStack().isEmpty())
					inventory.setItemStack(ItemStack.EMPTY);
				else inventory.setInventorySlotContents(inventory.currentItem, ItemStack.EMPTY);
				event.getEntityItem().remove();
			}
		}
	}
	
	@SubscribeEvent
	public static void onItemPickupEvent(EntityItemPickupEvent event) {
		if(event.getEntity().world.isRemote && isActive() && event.getPlayer().equals(Minecraft.getInstance().player))
			event.setCanceled(true);
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void onRightClickEvent(PlayerInteractEvent.RightClickBlock event)
	{
		if(event.getWorld().isRemote && event.getPlayer().isUser() && isActive())
		{
			Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
			ItemStack stack = event.getPlayer().getHeldItemMainhand();
			event.setUseBlock((block instanceof DoorBlock || block instanceof TrapDoorBlock || block instanceof FenceGateBlock) ? Event.Result.ALLOW : Event.Result.DENY);
			if(event.getUseBlock() == Event.Result.ALLOW)
				return;
			if(event.getHand().equals(Hand.OFF_HAND) || !ServerEditHandler.isBlockItem(stack.getItem()))
			{
				event.setCanceled(true);
				return;
			}
			
			GristSet cost = itemCost(stack, event.getWorld());
			if(!GristHelper.canAfford(ClientPlayerData.getClientGrist(), cost))
			{
				if(cost != null)
				{
					event.getPlayer().sendMessage(cost.createMissingMessage());
				}
				event.setCanceled(true);
			}
			if(event.getUseItem() == Event.Result.DEFAULT)
				event.setUseItem(Event.Result.ALLOW);
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public static void onLeftClickEvent(PlayerInteractEvent.LeftClickBlock event)
	{
		if(event.getWorld().isRemote && event.getPlayer().isUser() && isActive())
		{
			BlockState block = event.getWorld().getBlockState(event.getPos());
			if(block.getBlockHardness(event.getWorld(), event.getPos()) < 0 || block.getMaterial() == Material.PORTAL
					|| ClientPlayerData.getClientGrist().getGrist(GristTypes.BUILD) <= 0)
				event.setCanceled(true);
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public static void onRightClickAir(PlayerInteractEvent.RightClickItem event)
	{
		if(event.getWorld().isRemote && event.getPlayer().isUser() && isActive())
		{
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onAttackEvent(AttackEntityEvent event)
	{
		if(event.getEntity().world.isRemote && event.getPlayer().isUser() && isActive())
			event.setCanceled(true);
	}
	
	@SubscribeEvent
	public static void onWorldUnload(WorldEvent.Unload event)
	{
		if(event.getWorld().isRemote())
			activated = false;
	}
	
	@SubscribeEvent(priority=EventPriority.HIGH)
	public static void onGuiOpened(GuiOpenEvent event)
	{
		if(isActive() && event.getGui() instanceof DisplayEffectsScreen<?>)
		{
				event.setCanceled(true);
				PlayerStatsScreen.editmodeTab = PlayerStatsScreen.EditmodeGuiType.DEPLOY_LIST;
				PlayerStatsScreen.openGui(true);
		}
	}
}