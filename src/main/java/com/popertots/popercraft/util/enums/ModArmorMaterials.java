package com.popertots.popercraft.util.enums;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterials implements IArmorMaterial {
    MITHRIL(Popercraft.MOD_ID + ":mithril", 17, new int[] { 2, 5, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, .5F, () -> {
        return Ingredient.fromItems(ItemInit.mithril_ingot.get());
    }),
    MALACHITE(Popercraft.MOD_ID + ":malachite", 40, new int[] { 2, 5, 6, 2 }, 5, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F, () -> {
        return Ingredient.fromItems(ItemInit.malachite_ingot.get());
    }),
    ORICHALCUM(Popercraft.MOD_ID + ":orichalcum", 2, new int[] { 4, 7, 9, 4 }, 35, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3F, () -> {
        return Ingredient.fromItems(ItemInit.orichalcum_ingot.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmorMaterials(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
                              int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
                              Supplier<Ingredient> repairMaterialIn) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = soundEventIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}