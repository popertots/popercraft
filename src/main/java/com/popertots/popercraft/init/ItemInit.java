package com.popertots.popercraft.init;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.objects.items.*;
import com.popertots.popercraft.util.enums.ModArmorMaterials;
import com.popertots.popercraft.util.enums.ModItemTiers;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
            Popercraft.MOD_ID);


    public static final RegistryObject<Item> mithril_ingot = ITEMS.register("mithril_ingot",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<Item> malachite_ingot = ITEMS.register("malachite_ingot",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<Item> malachite_dust = ITEMS.register("malachite_dust",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<Item> orichalcum_ingot = ITEMS.register("orichalcum_ingot",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<Item> endrium = ITEMS.register("endrium",
            () -> new Endrium(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<Item> hard_snowball = ITEMS.register("hard_snowball",
            () -> new HardSnowball(new Item.Properties().maxStackSize(16).group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<Item> ooze_crystal = ITEMS.register("ooze_crystal",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<Item> imbued_mithril_ingot = ITEMS.register("imbued_mithril_ingot",
            () -> new GlowItem(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<Item> ring_item = ITEMS.register("ring_item",
            () -> new RingItem(new Item.Properties().maxStackSize(1).group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<Item> wand_item = ITEMS.register("wand_item",
            () -> new WandItem(new Item.Properties().maxDamage(64).group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<Item> flame_projectile_item = ITEMS.register("flame_projectile_item",
            () -> new Item(new Item.Properties().maxStackSize(1).group(Popercraft.PopercraftItemGroup.instance)));



    public static final RegistryObject<Item> milk_bowl = ITEMS.register("milk_bowl",
            () -> new bowl_food_item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance).maxStackSize(1).food(new Food.Builder().hunger(2)
                    .saturation(0.0f).build())));
    public static final RegistryObject<Item> cheese = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance).food(new Food.Builder().hunger(3)
                    .saturation(0.3f).build())));
    public static final RegistryObject<Item> pizza = ITEMS.register("pizza",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance).food(new Food.Builder().hunger(7)
                    .saturation(1).build())));
    public static final RegistryObject<Item> meat_pizza = ITEMS.register("meat_pizza",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance).food(new Food.Builder().hunger(14)
                    .saturation(2).build())));

    public static final RegistryObject<Item> lemon = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance).food(new Food.Builder().hunger(3)
                    .saturation(0.0f).build())));
    public static final RegistryObject<Item> orange = ITEMS.register("orange",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance).food(new Food.Builder().hunger(3)
                    .saturation(0.0f).build())));
    public static final RegistryObject<Item> lime = ITEMS.register("lime",
            () -> new Item(new Item.Properties().group(Popercraft.PopercraftItemGroup.instance).food(new Food.Builder().hunger(3)
                    .saturation(0.0f).build())));


    public static final RegistryObject<SwordItem> mithril_sword = ITEMS.register("mithril_sword",
            () -> new SwordItem(ModItemTiers.MITHRIL, 3, -2.4f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<PickaxeItem> mithril_pickaxe = ITEMS.register("mithril_pickaxe",
            () -> new PickaxeItem(ModItemTiers.MITHRIL, 0, -2.8f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<ShovelItem> mithril_shovel = ITEMS.register("mithril_shovel",
            () -> new ShovelItem(ModItemTiers.MITHRIL, 1, -3.0f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<AxeItem> mithril_axe = ITEMS.register("mithril_axe",
            () -> new AxeItem(ModItemTiers.MITHRIL, 3, -3.0f, new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<HoeItem> mithril_hoe = ITEMS.register("mithril_hoe",
            () -> new HoeItem(ModItemTiers.MITHRIL, -1.0f, new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<SwordItem> malachite_sword = ITEMS.register("malachite_sword",
            () -> new SwordItem(ModItemTiers.MALACHITE, 2, -2.4f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<PickaxeItem> malachite_pickaxe = ITEMS.register("malachite_pickaxe",
            () -> new PickaxeItem(ModItemTiers.MALACHITE, 0, -2.8f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<ShovelItem> malachite_shovel = ITEMS.register("malachite_shovel",
            () -> new ShovelItem(ModItemTiers.MALACHITE, 1, -3.0f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<AxeItem> malachite_axe = ITEMS.register("malachite_axe",
            () -> new AxeItem(ModItemTiers.MALACHITE, 2, -3.0f, new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<HoeItem> malachite_hoe = ITEMS.register("malachite_hoe",
            () -> new HoeItem(ModItemTiers.MALACHITE, -1.0f, new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<SwordItem> orichalcum_sword = ITEMS.register("orichalcum_sword",
            () -> new SwordItem(ModItemTiers.ORICHALCUM, 7, -2.4f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<PickaxeItem> orichalcum_pickaxe = ITEMS.register("orichalcum_pickaxe",
            () -> new PickaxeItem(ModItemTiers.ORICHALCUM, 1, -2.8f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<ShovelItem> orichalcum_shovel = ITEMS.register("orichalcum_shovel",
            () -> new ShovelItem(ModItemTiers.ORICHALCUM, 2, -3.0f,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<AxeItem> orichalcum_axe = ITEMS.register("orichalcum_axe",
            () -> new AxeItem(ModItemTiers.ORICHALCUM, 4, -3.0f, new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<HoeItem> orichalcum_hoe = ITEMS.register("orichalcum_hoe",
            () -> new HoeItem(ModItemTiers.ORICHALCUM, -1.0f, new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<Item> iron_bow = ITEMS.register("iron_bow",
            () -> new ModBow(new Item.Properties().maxDamage(550).group(Popercraft.PopercraftItemGroup.instance),2));
    public static final RegistryObject<Item> gold_bow = ITEMS.register("gold_bow",
            () -> new ModBow(new Item.Properties().maxDamage(700).group(Popercraft.PopercraftItemGroup.instance),3));
    public static final RegistryObject<Item> diamond_bow = ITEMS.register("diamond_bow",
            () -> new ModBow(new Item.Properties().maxDamage(1024).group(Popercraft.PopercraftItemGroup.instance),4));
    public static final RegistryObject<Item> wither_bow = ITEMS.register("wither_bow",
            () -> new ModBowWither(new Item.Properties().maxDamage(2000).group(Popercraft.PopercraftItemGroup.instance),1));



    public static final RegistryObject<ArmorItem> mithril_helmet = ITEMS.register("mithril_helmet",
            () -> new ArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlotType.HEAD,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> mithril_chestplate = ITEMS.register("mithril_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlotType.CHEST,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> mithril_leggings = ITEMS.register("mithril_leggings",
            () -> new ArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlotType.LEGS,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> mithril_boots = ITEMS.register("mithril_boots",
            () -> new ArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlotType.FEET,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<ArmorItem> malachite_helmet = ITEMS.register("malachite_helmet",
            () -> new ArmorItem(ModArmorMaterials.MALACHITE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> malachite_chestplate = ITEMS.register("malachite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MALACHITE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> malachite_leggings = ITEMS.register("malachite_leggings",
            () -> new ArmorItem(ModArmorMaterials.MALACHITE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> malachite_boots = ITEMS.register("malachite_boots",
            () -> new ArmorItem(ModArmorMaterials.MALACHITE, EquipmentSlotType.FEET,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

    public static final RegistryObject<ArmorItem> orichalcum_helmet = ITEMS.register("orichalcum_helmet",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, EquipmentSlotType.HEAD,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> orichalcum_chestplate = ITEMS.register("orichalcum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, EquipmentSlotType.CHEST,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> orichalcum_leggings = ITEMS.register("orichalcum_leggings",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, EquipmentSlotType.LEGS,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));
    public static final RegistryObject<ArmorItem> orichalcum_boots = ITEMS.register("orichalcum_boots",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, EquipmentSlotType.FEET,
                    new Item.Properties().group(Popercraft.PopercraftItemGroup.instance)));

}
