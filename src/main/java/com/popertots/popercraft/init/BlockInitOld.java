//package com.popertots.popercraft.init;
//
//import com.popertots.popercraft.Popercraft;
//
//import com.popertots.popercraft.objects.blocks.CitrusSaplingBlock;
//import com.popertots.popercraft.objects.blocks.EndriumBlock;
//import com.popertots.popercraft.objects.blocks.EndriumBlockItem;
//import com.popertots.popercraft.world.feature.LemonTree;
//import net.minecraft.block.*;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.material.MaterialColor;
//import net.minecraft.block.trees.Tree;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraftforge.common.ToolType;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
//import net.minecraftforge.registries.ObjectHolder;
//
//import java.util.function.Supplier;
//
//@Mod.EventBusSubscriber(modid = Popercraft.MOD_ID, bus = Bus.MOD)
//@ObjectHolder(Popercraft.MOD_ID)
//public class BlockInitOld {
//
//	public static final Block mithril_ore = null;
//	public static final Block malachite_ore = null;
//	public static final Block orichalcum_ore = null;
//	public static final Block endrium_ore = null;
//
//	public static final Block mithril_block = null;
//	public static final Block malachite_block = null;
//	public static final Block orichalcum_block = null;
//	public static final Block endrium_block = null;
//
//	public static final Block citrus_leaves = null;
//	public static final LogBlock lemon_log = null;
//	public static final Block lemon_planks = null;
//	public static final Block lemon_sapling = null;
//
//	@SubscribeEvent
//	public static void registerBlocks(final RegistryEvent.Register<Block> event)
//	{
//		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3, 3).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)).setRegistryName("mithril_ore"));
//		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3, 3).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName("malachite_ore"));
//		event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL)).setRegistryName("orichalcum_ore"));
//		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3, 3).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("endrium_ore"));
//
//		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("mithril_block"));
//		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("malachite_block"));
//		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("orichalcum_block"));
//		event.getRegistry().register(new EndriumBlock(Block.Properties.from(Blocks.COAL_BLOCK)).setRegistryName("endrium_block"));
//
//		event.getRegistry().register(new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)).setRegistryName("citrus_leaves"));
//		event.getRegistry().register(new LogBlock(MaterialColor.WOOD,Block.Properties.from(Blocks.OAK_LOG)).setRegistryName("lemon_log"));
//		event.getRegistry().register(new Block(Block.Properties.from(Blocks.OAK_PLANKS)).setRegistryName("lemon_planks"));
//		event.getRegistry().register(new Block(Block.Properties.from(Blocks.OAK_SAPLING)).setRegistryName("lemon_sapling"));
//
//
//	}
//
//	@SubscribeEvent
//	public static void registerItemBlocks(final RegistryEvent.Register<Item> event)
//	{
//		event.getRegistry().register(new BlockItem(mithril_ore,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mithril_ore"));
//		event.getRegistry().register(new BlockItem(malachite_ore,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("malachite_ore"));
//		event.getRegistry().register(new BlockItem(orichalcum_ore,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("orichalcum_ore"));
//		event.getRegistry().register(new BlockItem(endrium_ore,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("endrium_ore"));
//
//		event.getRegistry().register(new BlockItem(mithril_block,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mithril_block"));
//		event.getRegistry().register(new BlockItem(malachite_block,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("malachite_block"));
//		event.getRegistry().register(new BlockItem(orichalcum_block,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("orichalcum_block"));
//		event.getRegistry().register(new EndriumBlockItem(endrium_block,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("endrium_block"));
//
//		event.getRegistry().register(new BlockItem(citrus_leaves,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("citrus_leaves"));
//		event.getRegistry().register(new BlockItem(lemon_log,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("lemon_log"));
//		event.getRegistry().register(new BlockItem(lemon_planks,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("lemon_planks"));
//		event.getRegistry().register(new BlockItem(lemon_sapling,new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName("lemon_sapling"));
//
//	}
//}
