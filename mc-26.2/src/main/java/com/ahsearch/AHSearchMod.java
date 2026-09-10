package com.ahsearch;

import com.ahsearch.config.ConfigManager;
import com.ahsearch.util.ModLogger;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class AHSearchMod implements ModInitializer {
    public static final String MOD_ID = "ahsearch";

    @Override
    public void onInitialize() {
        ModLogger.info("Initializing AH Search+...");
        ConfigManager.load();
        ModLogger.info("AH Search+ initialized successfully.");
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
