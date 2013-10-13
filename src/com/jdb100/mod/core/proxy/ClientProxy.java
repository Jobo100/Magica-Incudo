package com.jdb100.mod.core.proxy;

import com.jdb100.mod.tileentity.TileMod;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy
{
	
	
	
	
	
    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

        if (tileEntity != null) {
            if (tileEntity instanceof TileMod) {
                ((TileMod) tileEntity).setOrientation(orientation);
                ((TileMod) tileEntity).setState(state);
                ((TileMod) tileEntity).setCustomName(customName);
            }
        }
    }
}
