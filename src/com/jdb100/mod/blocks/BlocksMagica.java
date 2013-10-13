package com.jdb100.mod.blocks;

import com.jdb100.mod.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public abstract class BlocksMagica extends BlockContainer {

	protected BlocksMagica(int id, Material material) {
		super(id, material);
		// TODO Auto-generated constructor stub
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}
	
	  protected String getUnwrappedUnlocalizedName(String unlocalizedName) 
	  {
		  return unlocalizedName.substring(unlocalizedName.indexOf(":") + 1);
	  }
}
