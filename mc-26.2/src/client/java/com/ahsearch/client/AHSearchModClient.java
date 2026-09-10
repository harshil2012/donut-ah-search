package com.ahsearch.client;

import com.ahsearch.util.ModLogger;
import net.fabricmc.api.ClientModInitializer;

public class AHSearchModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModLogger.info("Initializing Donut AH Search client side...");
        KeyBindingManager.register();
        ModCommands.register();
        ModLogger.info("Donut AH Search client side initialized.");
    }
}
