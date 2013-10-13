package com.jdb100.mod.blocks;

import com.jdb100.mod.lib.BlockIds;
import com.jdb100.mod.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks 
{

	public static Block spiritTable;
	
	
	
	public static void init()
	{
		spiritTable = new SpiritTable(BlockIds.SPIRIT_TABLE);
		
		
		GameRegistry.registerBlock(spiritTable, Strings.SPIRIT_TABLE_NAME);
		
		
		initBlockRecipes();
	}
	
	public static void initBlockRecipes()
	{
		
	}
}
