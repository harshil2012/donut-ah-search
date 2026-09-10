package com.ahsearch.config;

import com.ahsearch.util.ModLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static File configFile;
    private static ModConfig config;

    public static void load() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("ahsearch.json");
        configFile = configPath.toFile();

        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                config = GSON.fromJson(reader, ModConfig.class);
                if (config == null) {
                    config = new ModConfig();
                }
                // Migrate old default: if searchMode was "ID" (the old broken default),
                // auto-upgrade to "DISPLAY_NAME" and save so the fix takes effect.
                if ("ID".equalsIgnoreCase(config.searchMode)) {
                    config.searchMode = "DISPLAY_NAME";
                    save();
                    ModLogger.info("Migrated searchMode from ID to DISPLAY_NAME.");
                }
                ModLogger.info("Configuration loaded successfully.");
            } catch (Exception e) {
                ModLogger.error("Failed to load configuration, using defaults.", e);
                config = new ModConfig();
            }
        } else {
            config = new ModConfig();
            save();
        }
    }

    public static void save() {
        if (config == null) {
            config = new ModConfig();
        }
        try {
            File parent = configFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            try (FileWriter writer = new FileWriter(configFile)) {
                GSON.toJson(config, writer);
                ModLogger.info("Configuration saved successfully.");
            }
        } catch (IOException e) {
            ModLogger.error("Failed to save configuration.", e);
        }
    }

    public static ModConfig getConfig() {
        if (config == null) {
            load();
        }
        return config;
    }
}
