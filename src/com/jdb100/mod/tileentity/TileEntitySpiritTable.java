package com.jdb100.mod.tileentity;

import com.jdb100.mod.lib.Strings;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntitySpiritTable extends TileMod implements IInventory
{
	
	private ItemStack inventory[];
	public static final int INVENTORY_SIZE = 3;
	
	public TileEntitySpiritTable()
	{
		inventory = new ItemStack[INVENTORY_SIZE];
	}
	
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex) {
		// TODO Auto-generated method stub
		return inventory[slotIndex];
	}

    @Override
    public ItemStack decrStackSize(int slotIndex, int decrementAmount) 
    {

        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null) {
            if (itemStack.stackSize <= decrementAmount) {
                setInventorySlotContents(slotIndex, null);
            }
            else {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.stackSize == 0) {
                    setInventorySlotContents(slotIndex, null);
                }
            }
        }

        return itemStack;
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {
		// TODO Auto-generated method stub
		ItemStack itemstack = getStackInSlot(slotIndex);
		if( itemstack != null)
			this.setInventorySlotContents(slotIndex, null);
		return null;
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemstack) {
		// TODO Auto-generated method stub
		inventory[slotIndex] = itemstack;
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
			itemstack.stackSize = getInventoryStackLimit();
		
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_SPIRIT_TABLE_NAME;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return this.hasCustomName();
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int slotIndex, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return true;
	}
	
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString());

        stringBuilder.append("TileSpiritTable Data - ");
        for (int i = 0; i < inventory.length; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }

            if (inventory[i] != null) {
                stringBuilder.append(String.format("inventory[%d]: %s", i, inventory[i].toString()));
            }
            else {
                stringBuilder.append(String.format("inventory[%d]: empty", i));
            }
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < inventory.length) {
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
            if (inventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }

}
