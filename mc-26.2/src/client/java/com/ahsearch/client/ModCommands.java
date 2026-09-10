package com.ahsearch.client;

import com.ahsearch.config.ConfigManager;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.network.chat.Component;

public class ModCommands {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(LiteralArgumentBuilder.<FabricClientCommandSource>literal("ahsearch")
                .then(LiteralArgumentBuilder.<FabricClientCommandSource>literal("prefix")
                    .then(RequiredArgumentBuilder.<FabricClientCommandSource, String>argument("prefix", StringArgumentType.greedyString())
                        .executes(context -> {
                            String newPrefix = StringArgumentType.getString(context, "prefix");
                            ConfigManager.getConfig().commandPrefix = newPrefix;
                            ConfigManager.save();
                            context.getSource().sendFeedback(Component.literal("Donut AH Search command prefix set to: /" + newPrefix));
                            return 1;
                        })
                    )
                )
                .then(LiteralArgumentBuilder.<FabricClientCommandSource>literal("mode")
                    .then(LiteralArgumentBuilder.<FabricClientCommandSource>literal("id")
                        .executes(context -> {
                            ConfigManager.getConfig().searchMode = "ID";
                            ConfigManager.save();
                            context.getSource().sendFeedback(Component.literal("Donut AH Search mode set to ID (registry ID path)."));
                            return 1;
                        })
                    )
                    .then(LiteralArgumentBuilder.<FabricClientCommandSource>literal("name")
                        .executes(context -> {
                            ConfigManager.getConfig().searchMode = "DISPLAY_NAME";
                            ConfigManager.save();
                            context.getSource().sendFeedback(Component.literal("Donut AH Search mode set to DISPLAY_NAME (localized item name)."));
                            return 1;
                        })
                    )
                )
                .then(LiteralArgumentBuilder.<FabricClientCommandSource>literal("status")
                    .executes(context -> {
                        String prefix = ConfigManager.getConfig().commandPrefix;
                        String mode = ConfigManager.getConfig().searchMode;
                        context.getSource().sendFeedback(Component.literal("Donut AH Search Status:\n- Prefix: /" + prefix + "\n- Search Mode: " + mode));
                        return 1;
                    })
                )
            );
        });
    }
}
