package com.jdb100.mod;

import java.io.File;

import com.jdb100.mod.blocks.ModBlocks;
import com.jdb100.mod.configuration.ConfigurationHandler;
import com.jdb100.mod.core.proxy.CommonProxy;
import com.jdb100.mod.items.ModItems;
import com.jdb100.mod.lib.Reference;
import com.jdb100.mod.util.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Core 
{
	
	@Instance(Reference.MOD_ID)
	public static Core instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		//initialize logger
		LogHelper.init();
		
		//initialize config
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
		
		//initialize blocks
		ModBlocks.init();
		
		//initialize items
		ModItems.init();
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event)
	{

	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
