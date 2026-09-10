package com.ahsearch.client;

import com.ahsearch.config.ConfigManager;
import com.ahsearch.util.ModLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ChatCommandSender {
    public static void sendSearchCommand(String query) {
        if (query == null || query.isEmpty()) {
            return;
        }

        Minecraft client = Minecraft.getInstance();
        if (client == null || client.player == null) {
            ModLogger.warn("Cannot send command: player is not in a world.");
            return;
        }

        if (client.getConnection() == null) {
            ModLogger.warn("Cannot send command: connection is null.");
            return;
        }

        String prefix = ConfigManager.getConfig().commandPrefix;
        if (prefix == null) {
            prefix = "ah";
        }
        
        // Strip leading slash if present, as sendCommand expects it without a slash
        if (prefix.startsWith("/")) {
            prefix = prefix.substring(1);
        }

        String fullCommand = (prefix + " " + query).trim();
        try {
            // Show feedback in chat so the player sees what was searched
            client.player.sendSystemMessage(
                Component.literal("§a[Donut AH Search] §fSearching: §e/" + fullCommand)
            );

            client.getConnection().sendCommand(fullCommand);
            ModLogger.info("Sent Auction House command: /%s", fullCommand);
        } catch (Exception e) {
            ModLogger.error("Failed to send command: " + fullCommand, e);
        }
    }
}
