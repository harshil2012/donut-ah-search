package com.ahsearch.util;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class EnchantmentReader {
    public static Map<String, Integer> getEnchantments(ItemStack stack) {
        Map<String, Integer> enchantmentsMap = new LinkedHashMap<>();
        if (stack == null || stack.isEmpty()) {
            return enchantmentsMap;
        }

        processEnchantments(stack.get(DataComponents.ENCHANTMENTS), enchantmentsMap);
        processEnchantments(stack.get(DataComponents.STORED_ENCHANTMENTS), enchantmentsMap);

        return enchantmentsMap;
    }

    private static void processEnchantments(ItemEnchantments enchantments, Map<String, Integer> map) {
        if (enchantments != null) {
            for (var entry : enchantments.entrySet()) {
                Holder<Enchantment> enchantmentHolder = entry.getKey();
                int level = entry.getIntValue();
                if (level > 0) {
                    Optional<ResourceKey<Enchantment>> keyOpt = enchantmentHolder.unwrapKey();
                    if (keyOpt.isPresent()) {
                        String idPath = keyOpt.get().identifier().getPath();
                        String name = idPath.replace('_', ' ');
                        map.put(name, level);
                    }
                }
            }
        }
    }
}
