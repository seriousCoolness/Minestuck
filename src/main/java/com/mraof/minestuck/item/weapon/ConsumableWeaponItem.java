package com.mraof.minestuck.item.weapon;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ConsumableWeaponItem extends WeaponItem
{
	private final int healAmount;
    private final float saturationModifier;
    private final int damageTaken;
	private EffectInstance potionId;
	private float potionEffectProbability;
	
	public ConsumableWeaponItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, float efficiency, int healAmount, float saturationModifier, int damageTaken, MSToolType toolType, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, efficiency, toolType, builder);
		this.healAmount = healAmount;
		this.saturationModifier = saturationModifier;
		this.damageTaken = damageTaken;
	}
	
	public ConsumableWeaponItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, float efficiency, int healAmount, float saturationModifier, MSToolType toolType, Properties builder)
	{
		this(tier, attackDamageIn, attackSpeedIn, efficiency, healAmount, saturationModifier, 50, toolType, builder);
	}
	
	@Override
	public int getUseDuration(ItemStack stack)
	{
		return 32;
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack)
	{
		return UseAction.EAT;
	} 
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
	{
		stack.damageItem(this.damageTaken, entityLiving, entity -> entity.sendBreakAnimation(Hand.MAIN_HAND));
		this.onFoodEaten(stack, worldIn, entityLiving);
		
		if(entityLiving instanceof PlayerEntity)
		{
			PlayerEntity entityplayer = (PlayerEntity) entityLiving;
			entityplayer.getFoodStats().addStats(this.healAmount, this.saturationModifier);
			worldIn.playSound(null, entityplayer.getPosX(), entityplayer.getPosY(), entityplayer.getPosZ(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
		}
		return stack;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		playerIn.setActiveHand(handIn);
		return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	public ConsumableWeaponItem setPotionEffect(EffectInstance effect, float probability)
    {
        this.potionId = effect;
        this.potionEffectProbability = probability;
        
        return this;
    }
	
	protected void onFoodEaten(ItemStack stack, World worldIn, LivingEntity player)
    {
        if (!worldIn.isRemote && this.potionId != null && worldIn.rand.nextFloat() < this.potionEffectProbability)
        {
            player.addPotionEffect(new EffectInstance(this.potionId));
        }
    }
}
