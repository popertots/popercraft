//package com.popertots.popercraft.init;
//
//import java.util.function.Supplier;
//
//import com.popertots.popercraft.Popercraft;
//import com.popertots.popercraft.objects.items.Endrium;
//import com.popertots.popercraft.objects.items.RingItem;
//import com.popertots.popercraft.objects.items.bowl_food_item;
//
//import net.minecraft.item.AxeItem;
//import net.minecraft.item.Food;
//import net.minecraft.item.HoeItem;
//import net.minecraft.item.IItemTier;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.PickaxeItem;
//import net.minecraft.item.ShovelItem;
//import net.minecraft.item.SwordItem;
//import net.minecraft.item.crafting.Ingredient;
//import net.minecraft.util.LazyValue;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
//import net.minecraftforge.registries.ObjectHolder;
//
//@Mod.EventBusSubscriber(modid = Popercraft.MOD_ID, bus = Bus.MOD)
//@ObjectHolder(Popercraft.MOD_ID)
//public class ItemInitOld
//{
//	public static final Item mithril_ingot = null;
//	public static final Item malachite_ingot = null;
//	public static final Item malachite_dust = null;
//	public static final Item orichalcum_ingot = null;
//	public static final Item ring_item = null;
//
//	//mithril tools
//	public static final Item mithril_sword = null;
//	public static final Item mithril_pickaxe = null;
//	public static final Item mithril_shovel = null;
//	public static final Item mithril_axe = null;
//	public static final Item mithril_hoe = null;
//
//	//malachite tools
//	public static final Item malachite_sword = null;
//	public static final Item malachite_pickaxe = null;
//	public static final Item malachite_shovel = null;
//	public static final Item malachite_axe = null;
//	public static final Item malachite_hoe = null;
//
//	//orichalcum tools
//	public static final Item orichalcum_sword = null;
//	public static final Item orichalcum_pickaxe = null;
//	public static final Item orichalcum_shovel = null;
//	public static final Item orichalcum_axe = null;
//	public static final Item orichalcum_hoe = null;
//
//	//food
//	public static final Item milk_bowl = null;
//	public static final Item cheese = null;
//	public static final Item pizza = null;
//	public static final Item meat_pizza = null;
//
//
//
//	@SubscribeEvent
//	public static void registerItems(final RegistryEvent.Register<Item> event)
//	{
//		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("mithril_ingot"));
//		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("malachite_ingot"));
//		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("malachite_dust"));
//		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("orichalcum_ingot"));
//		event.getRegistry().register(new Endrium(new Endrium.Properties().group(ItemGroup.MATERIALS)).setRegistryName("endrium"));
//		event.getRegistry().register(new RingItem(new RingItem.Properties().group(ItemGroup.BREWING).maxStackSize(1)).setRegistryName("ring_item"));
//
//		//mithril tools
//		event.getRegistry().register(new SwordItem(ModItemTier.MITHRIL,3,-2.4f,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mithril_sword"));
//		event.getRegistry().register(new PickaxeItem(ModItemTier.MITHRIL,0,-2.8f,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mithril_pickaxe"));
//		event.getRegistry().register(new ShovelItem(ModItemTier.MITHRIL,1,-3,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mithril_shovel"));
//		event.getRegistry().register(new AxeItem(ModItemTier.MITHRIL,3,-3,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mithril_axe"));
//		event.getRegistry().register(new HoeItem(ModItemTier.MITHRIL,-1f,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mithril_hoe"));
//
//		//malachite tools
//		event.getRegistry().register(new SwordItem(ModItemTier.MALACHITE,2,-2.4f,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("malachite_sword"));
//		event.getRegistry().register(new PickaxeItem(ModItemTier.MALACHITE,0,-2.8f,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("malachite_pickaxe"));
//		event.getRegistry().register(new ShovelItem(ModItemTier.MALACHITE,1,-3,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("malachite_shovel"));
//		event.getRegistry().register(new AxeItem(ModItemTier.MALACHITE,2,-3,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("malachite_axe"));
//		event.getRegistry().register(new HoeItem(ModItemTier.MALACHITE,-1f,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("malachite_hoe"));
//
//		//orichalcum tools
//		event.getRegistry().register(new SwordItem(ModItemTier.ORICHALCUM,7,-2.4f,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("orichalcum_sword"));
//		event.getRegistry().register(new PickaxeItem(ModItemTier.ORICHALCUM,1,-2.8f,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("orichalcum_pickaxe"));
//		event.getRegistry().register(new ShovelItem(ModItemTier.ORICHALCUM,2,-3,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("orichalcum_shovel"));
//		event.getRegistry().register(new AxeItem(ModItemTier.ORICHALCUM,4,-3,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("orichalcum_axe"));
//		event.getRegistry().register(new HoeItem(ModItemTier.ORICHALCUM,-1f,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("orichalcum_hoe"));
//
//		//food
//		event.getRegistry().register(new bowl_food_item(new bowl_food_item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(2).saturation(0).build())).setRegistryName("milk_bowl"));
//		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(.3f).build())).setRegistryName("cheese"));
//		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(7).saturation(1).build())).setRegistryName("pizza"));
//		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(14).saturation(2).build())).setRegistryName("meat_pizza"));
//}
//
//	public enum ModItemTier implements IItemTier{
//		MITHRIL(2,350,8.0f,3f,12,() -> {
//			return Ingredient.fromItems(ItemInitOld.mithril_ingot);
//		}),
//		MALACHITE(2, 4096, 4.0f, 3f, 5,() -> {
//			return Ingredient.fromItems(ItemInitOld.malachite_ingot);
//		}),
//		ORICHALCUM(3, 32, 20.0f, 3f, 50,() -> {
//			return Ingredient.fromItems(ItemInitOld.orichalcum_ingot);
//		});
//
//		private final int harvestLevel;
//		private final int maxUses;
//		private final float efficiency;
//		private final float attackDamage;
//		private final int enchantability;
//		private final LazyValue<Ingredient> repairMaterial;
//
//		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
//			this.harvestLevel = harvestLevel;
//			this.maxUses = maxUses;
//			this.efficiency = efficiency;
//			this.attackDamage = attackDamage;
//			this.enchantability = enchantability;
//			this.repairMaterial = new LazyValue<>(repairMaterial);
//		}
//
//		@Override
//		public int getMaxUses() {
//			return maxUses;
//		}
//
//		@Override
//		public float getEfficiency() {
//			return efficiency;
//		}
//
//		@Override
//		public float getAttackDamage() {
//			return attackDamage;
//		}
//
//		@Override
//		public int getHarvestLevel() {
//			return harvestLevel;
//		}
//
//		@Override
//		public int getEnchantability() {
//			return enchantability;
//		}
//
//		@Override
//		public Ingredient getRepairMaterial() {
//			return repairMaterial.getValue();
//		}
//	}
//}
