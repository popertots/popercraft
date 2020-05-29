package com.popertots.popercraft.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlowItem extends Item {
    public GlowItem(Properties properties) { super(properties); }
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}
