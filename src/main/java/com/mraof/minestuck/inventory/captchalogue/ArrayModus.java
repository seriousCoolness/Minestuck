package com.mraof.minestuck.inventory.captchalogue;

import com.mraof.minestuck.MinestuckConfig;
import com.mraof.minestuck.item.MSItems;
import com.mraof.minestuck.item.crafting.alchemy.AlchemyHelper;
import com.mraof.minestuck.world.storage.PlayerSavedData;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.LogicalSide;

import java.util.Iterator;

public class ArrayModus extends Modus
{

    protected int size;
    protected NonNullList<ItemStack> list;

    //client side
    protected boolean changed;
    protected NonNullList<ItemStack> items;

    public ArrayModus(ModusType<? extends ArrayModus> type, PlayerSavedData savedData, LogicalSide side)
    {
        super(type, savedData, side);
    }

    @Override
    public void initModus(ItemStack modusItem, ServerPlayerEntity player, NonNullList<ItemStack> prev, int size)
        {
            this.size = size;
            this.list = NonNullList.create();
            if (prev != null)
            {
                Iterator var3 = prev.iterator();

                while(var3.hasNext())
                {
                    ItemStack stack = (ItemStack) var3.next();
                    if(!stack.isEmpty())
                    {
                        this.list.add(stack);
                    }
                }
            }
        }

    public void readFromNBT(CompoundNBT nbt) {
        this.size = nbt.getInt("size");
        this.list = NonNullList.create();

        for(int i = 0; i < this.size && nbt.contains("item" + i); ++i) {
            this.list.add(ItemStack.read(nbt.getCompound("item" + i)));
        }

        if (this.side.isClient()) {
            this.items = NonNullList.create();
            this.changed = true;
        }

    }

    @Override
    public CompoundNBT writeToNBT(CompoundNBT nbt) {
        nbt.putInt("size", size);
        Iterator<ItemStack> iter = list.iterator();
        for(int i = 0; i < list.size(); i++)
        {
            ItemStack stack = iter.next();
            nbt.put("item"+i, stack.write(new CompoundNBT()));
        }
        return nbt;
    }

    @Override
    public boolean putItemStack(ServerPlayerEntity player, ItemStack item)
    {

        if(item.isEmpty())
            return false;

        for(int i = 0; i < list.size(); i++)
            if(list.get(i).isEmpty())
            {
                list.set(i, item);
                markDirty();
                return true;
            }

        if(size <= list.size())
            return false;

        list.add(item);
        markDirty();
        return true;
    }

    @Override
    public NonNullList<ItemStack> getItems()
    {
        if (side == LogicalSide.SERVER) {
            NonNullList<ItemStack> items = NonNullList.create();
            fillList(items);
            return items;
        }
            if (changed)
                fillList(items);
            return items;
    }

    protected void fillList(NonNullList<ItemStack> items)
    {
        items.clear();
        Iterator<ItemStack> iter = this.list.iterator();

        for(int i = 0; i < this.size; ++i) {
            if (iter.hasNext()) {
                items.add(iter.next());
            } else {
                items.add(ItemStack.EMPTY);
            }
        }

    }

    @Override
    public boolean increaseSize(ServerPlayerEntity player) {
        if(MinestuckConfig.SERVER.modusMaxSize.get() > 0 && size >= MinestuckConfig.SERVER.modusMaxSize.get())
            return false;

        size++;
        markDirty();

        return true;
    }

    @Override
    public ItemStack getItem(ServerPlayerEntity player, int id, boolean asCard)
    {
        if(id == CaptchaDeckHandler.EMPTY_CARD)
        {
            if(list.size() < size)
            {
                size--;
                markDirty();
                return new ItemStack(MSItems.CAPTCHA_CARD);
            } else return ItemStack.EMPTY;
        }

        if(list.isEmpty())
            return ItemStack.EMPTY;

        if(id == CaptchaDeckHandler.EMPTY_SYLLADEX)
        {
            for(ItemStack item : list)
                CaptchaDeckHandler.launchAnyItem(player, item);
            list.clear();
            markDirty();
            return ItemStack.EMPTY;
        }

        if(id < 0 || id >= list.size())
            return ItemStack.EMPTY;

        ItemStack item = list.remove(id);
        markDirty();

        if(asCard)
        {
            size--;
            markDirty();
            item = AlchemyHelper.createCard(item, false);
        }

        return item;
    }

    @Override
    public boolean canSwitchFrom(Modus modus)
    {
        return false;
    }

    @Override
    public int getSize()
    {
        return size;
    }
}
