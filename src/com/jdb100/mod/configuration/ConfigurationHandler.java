package com.jdb100.mod.configuration;

import java.io.File;
import java.util.logging.Level;

import com.jdb100.mod.lib.BlockIds;
import com.jdb100.mod.lib.Strings;
import com.jdb100.mod.lib.Reference;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;

public class ConfigurationHandler 
{
	public static Configuration configuration;
	
    public static final String CATEGORY_KEYBIND = "keybindings";
    public static final String CATEGORY_GRAPHICS = "graphics";
    public static final String CATEGORY_AUDIO = "audio";
    public static final String CATEGORY_DURABILITY = Configuration.CATEGORY_ITEM + Configuration.CATEGORY_SPLITTER + "durability";
    
    public static void init(File configFile)
    {
    	
    	configuration = new Configuration(configFile);
    	try{
    		configuration.load();
    	
    	
    		//BlockIDs
    		BlockIds.SPIRIT_TABLE = configuration.getBlock(Strings.SPIRIT_TABLE_NAME, BlockIds.SPIRIT_TABLE_DEFAULT).getInt(BlockIds.SPIRIT_TABLE_DEFAULT);
    		
    		
    		
    		
    		}
    		catch(Exception e)
    		{
    		 FMLLog.log(Level.SEVERE, e, Reference.NAME + " has had a problem loading its configuration");
    		}
    	
    	finally{
    		configuration.save();
    	}
    }
}
