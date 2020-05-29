package com.popertots.popercraft.init;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.enchantments.LastChanceEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(
            ForgeRegistries.ENCHANTMENTS, Popercraft.MOD_ID);

    public static final RegistryObject<Enchantment> last_chance = ENCHANTMENTS.register("last_chance",
            () -> new LastChanceEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR,
                    new EquipmentSlotType[] { EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET }));
}