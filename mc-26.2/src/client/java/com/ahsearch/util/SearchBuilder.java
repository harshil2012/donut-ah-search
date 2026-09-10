package com.ahsearch.util;

import com.ahsearch.config.ConfigManager;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class SearchBuilder {
    public static String buildQuery(ItemStack stack) {
        if (stack == null || stack.isEmpty()) {
            return "";
        }

        String mode = ConfigManager.getConfig().searchMode;
        String itemName;

        if ("ID".equalsIgnoreCase(mode)) {
            // Registry ID mode: "cooked_beef" -> "cooked beef", "tipped_arrow" -> "tipped arrow"
            itemName = getRegistryPath(stack);
        } else {
            // DISPLAY_NAME mode (default): uses the exact localized name from the tooltip.
            // This correctly resolves:
            //   Steak (cooked_beef) -> "Steak"
            //   Minecart with Hopper (hopper_minecart) -> "Minecart with Hopper"
            //   Minecart with Chest (chest_minecart) -> "Minecart with Chest"
            //   Arrow of Healing (tipped_arrow) -> "Arrow of Healing"
            //   Arrow of Slowness (tipped_arrow) -> "Arrow of Slowness"
            //   Potion of Regeneration (potion) -> "Potion of Regeneration"
            //   Splash Potion of Regeneration (splash_potion) -> "Splash Potion of Regeneration"
            //   Lingering Potion of Harming (lingering_potion) -> "Lingering Potion of Harming"
            //   Anvil-renamed items -> the custom name
            itemName = getDisplayName(stack);
        }

        if (itemName == null || itemName.isEmpty()) {
            return "";
        }

        StringBuilder query = new StringBuilder(itemName);

        // Append enchantments (handles both standard items & Enchanted Books via STORED_ENCHANTMENTS)
        Map<String, Integer> enchantments = EnchantmentReader.getEnchantments(stack);
        for (Map.Entry<String, Integer> entry : enchantments.entrySet()) {
            query.append(" ")
                 .append(entry.getKey())
                 .append(" ")
                 .append(entry.getValue());
        }

        return query.toString().trim();
    }

    /**
     * Returns the exact localized display name shown in the item tooltip.
     * Strips any Minecraft formatting codes (§ symbols).
     */
    private static String getDisplayName(ItemStack stack) {
        try {
            String raw = stack.getHoverName().getString();
            if (raw == null || raw.isEmpty()) {
                return getRegistryPath(stack);
            }
            // Strip Minecraft formatting codes like §a, §f, §l, §r etc.
            String clean = raw.replaceAll("§[0-9a-fk-orA-FK-OR]", "").trim();
            return clean.toLowerCase();
        } catch (Exception e) {
            return getRegistryPath(stack);
        }
    }

    /**
     * Returns the registry ID path with underscores replaced by spaces.
     * e.g. "cooked_beef" -> "cooked beef", "hopper_minecart" -> "hopper minecart"
     */
    private static String getRegistryPath(ItemStack stack) {
        Identifier id = BuiltInRegistries.ITEM.getKey(stack.getItem());
        if (id != null) {
            String path = id.getPath();
            if (path != null) {
                return path.toLowerCase().replace('_', ' ');
            }
        }
        return "";
    }
}
