package com.jdb100.mod.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.jdb100.mod.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static Logger logger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        logger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, Object object) {

        logger.log(logLevel, object.toString());
    }

    public static void severe(Object object) {

        log(Level.SEVERE, object);
    }

    public static void debug(Object object) {

        log(Level.WARNING, "[DEBUG] " + object);
    }

    public static void warning(Object object) {

        log(Level.WARNING, object);
    }

    public static void info(Object object) {

        log(Level.INFO, object);
    }

    public static void config(Object object) {

        log(Level.CONFIG, object);
    }

    public static void fine(Object object) {

        log(Level.FINE, object);
    }

    public static void finer(Object object) {

        log(Level.FINER, object);
    }

    public static void finest(Object object) {

        log(Level.FINEST, object);
    }
}