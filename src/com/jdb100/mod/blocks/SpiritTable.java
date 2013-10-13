package com.jdb100.mod.blocks;

import com.jdb100.mod.Core;
import com.jdb100.mod.lib.GuiIds;
import com.jdb100.mod.lib.Strings;
import com.jdb100.mod.tileentity.TileEntitySpiritTable;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SpiritTable extends BlocksMagica
{

	public SpiritTable(int par1)
	{
		super(par1, Material.wood);
		this.setUnlocalizedName(Strings.SPIRIT_TABLE_NAME);
		this.setHardness(2.0f);
		this.setStepSound(soundWoodFootstep);
		
		
	}
	
	
	
    @Override
    public String getUnlocalizedName() {

        StringBuilder unlocalizedName = new StringBuilder();

        unlocalizedName.append("tile.");
        unlocalizedName.append(Strings.RESOURCE_PREFIX);
        unlocalizedName.append(Strings.SPIRIT_TABLE_NAME);

        return unlocalizedName.toString();
    }



	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntitySpiritTable();
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

        if (player.isSneaking())
            return false;
        else {
            if (!world.isRemote) {
                TileEntitySpiritTable tileCalcinator = (TileEntitySpiritTable) world.getBlockTileEntity(x, y, z);

                if (tileCalcinator != null) {
                    player.openGui(Core.instance, GuiIds.SPIRITTABLE, world, x, y, z);
                }
            }

            return true;
        }
    }

}
