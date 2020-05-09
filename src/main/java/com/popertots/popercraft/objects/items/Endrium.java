package com.popertots.popercraft.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Endrium extends Item {

    public Endrium(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 6400;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
