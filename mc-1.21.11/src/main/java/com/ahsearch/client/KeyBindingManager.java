package com.ahsearch.client;

import com.ahsearch.util.ModLogger;
import com.ahsearch.util.SearchBuilder;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.glfw.GLFW;

public class KeyBindingManager {
    public static KeyMapping searchKeyBinding;
    public static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(
        Identifier.fromNamespaceAndPath("ahsearch", "general")
    );

    public static void register() {
        searchKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.ahsearch.search", 
            InputConstants.Type.KEYSYM, 
            GLFW.GLFW_KEY_0, 
            CATEGORY
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // consumeClick() ensures it only triggers once per press, avoiding duplicate executions
            while (searchKeyBinding.consumeClick()) {
                handleKeyPress(client);
            }
        });
    }

    private static void handleKeyPress(net.minecraft.client.Minecraft client) {
        ModLogger.info("AH Search hotkey pressed.");
        
        Player player = client.player;
        if (player == null) {
            return;
        }

        // Read the item in the main hand
        ItemStack heldItem = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (heldItem == null || heldItem.isEmpty()) {
            ModLogger.info("Main hand is empty. Doing nothing.");
            return;
        }

        try {
            // Build the search query
            String query = SearchBuilder.buildQuery(heldItem);
            if (query.isEmpty()) {
                return;
            }

            ModLogger.info("Generated query: " + query);

            // Send the command directly
            ChatCommandSender.sendSearchCommand(query);
        } catch (Exception e) {
            ModLogger.error("Error processing item search query: ", e);
        }
    }
}
