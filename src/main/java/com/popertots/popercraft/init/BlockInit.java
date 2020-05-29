package com.popertots.popercraft.init;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.objects.blocks.*;
import com.popertots.popercraft.world.feature.LemonTree;
import com.popertots.popercraft.world.feature.LimeTree;
import com.popertots.popercraft.world.feature.OrangeTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
            Popercraft.MOD_ID);

    public static final RegistryObject<Block> escape_block = BLOCKS.register("escape_block", () -> new Block(
            EscapeBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> mithril_ore = BLOCKS.register("mithril_ore", () -> new Block(
            Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> malachite_ore = BLOCKS.register("malachite_ore", () -> new Block(
            Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> orichalcum_ore = BLOCKS.register("orichalcum_ore", () -> new Block(
            Block.Properties.from(Blocks.DIRT)));
    public static final RegistryObject<Block> endrium_ore = BLOCKS.register("endrium_ore", () -> new Block(
            Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> mithril_block = BLOCKS.register("mithril_block", () -> new Block(
            Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> malachite_block = BLOCKS.register("malachite_block", () -> new Block(
            Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> orichalcum_block = BLOCKS.register("orichalcum_block", () -> new Block(
            Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> endrium_block = BLOCKS.register("endrium_block", () -> new EndriumBlock(
            Block.Properties.from(Blocks.COAL_BLOCK)));

    public static final RegistryObject<Block> lemon_leaves = BLOCKS.register("lemon_leaves", () -> new ModLeavesBlock(
            Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> orange_leaves = BLOCKS.register("orange_leaves", () -> new ModLeavesBlock(
            Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> lime_leaves = BLOCKS.register("lime_leaves", () -> new ModLeavesBlock(
            Block.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> lemon_log = BLOCKS.register("lemon_log", () -> new ModLogBlock(MaterialColor.WOOD,
            Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> orange_log = BLOCKS.register("orange_log", () -> new ModLogBlock(MaterialColor.WOOD,
            Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> lime_log = BLOCKS.register("lime_log", () -> new ModLogBlock(MaterialColor.WOOD,
            Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> lemon_planks = BLOCKS.register("lemon_planks", () -> new ModPlankBlock(
            Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> orange_planks = BLOCKS.register("orange_planks", () -> new ModPlankBlock(
            Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> lime_planks = BLOCKS.register("lime_planks", () -> new ModPlankBlock(
            Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> lemon_slab = BLOCKS.register("lemon_slab",
            () -> new SlabBlock(Block.Properties.from(lemon_planks.get())));
    public static final RegistryObject<Block> orange_slab = BLOCKS.register("orange_slab",
            () -> new SlabBlock(Block.Properties.from(orange_planks.get())));
    public static final RegistryObject<Block> lime_slab = BLOCKS.register("lime_slab",
            () -> new SlabBlock(Block.Properties.from(lime_planks.get())));

    public static final RegistryObject<Block> lemon_sapling = BLOCKS.register("lemon_sapling", () -> new CitrusSaplingBlock( () -> new LemonTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> orange_sapling = BLOCKS.register("orange_sapling", () -> new CitrusSaplingBlock( () -> new OrangeTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> lime_sapling = BLOCKS.register("lime_sapling", () -> new CitrusSaplingBlock( () -> new LimeTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> lemon_stairs = BLOCKS.register("lemon_stairs",
            () -> new ModWoodenStairs(() -> lemon_planks.get().getDefaultState(),
                    Block.Properties.from(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> orange_stairs = BLOCKS.register("orange_stairs",
            () -> new ModWoodenStairs(() -> orange_planks.get().getDefaultState(),
                    Block.Properties.from(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> lime_stairs = BLOCKS.register("lime_stairs",
            () -> new ModWoodenStairs(() -> lime_planks.get().getDefaultState(),
                    Block.Properties.from(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> lemon_fence = BLOCKS.register("lemon_fence",
            () -> new ModWoodenFence(Block.Properties.from(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> orange_fence = BLOCKS.register("orange_fence",
            () -> new ModWoodenFence(Block.Properties.from(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> lime_fence = BLOCKS.register("lime_fence",
            () -> new ModWoodenFence(Block.Properties.from(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> lemon_button = BLOCKS.register("lemon_button",
            () -> new ModWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> orange_button = BLOCKS.register("orange_button",
            () -> new ModWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> lime_button = BLOCKS.register("lime_button",
            () -> new ModWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));

    public static final RegistryObject<Block> lemon_pressure_plate = BLOCKS.register("lemon_pressure_plate",
            () -> new ModPressurePlateBlock(ModPressurePlateBlock.Sensitivity.EVERYTHING,
                    Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> orange_pressure_plate = BLOCKS.register("orange_pressure_plate",
            () -> new ModPressurePlateBlock(ModPressurePlateBlock.Sensitivity.EVERYTHING,
                    Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> lime_pressure_plate = BLOCKS.register("lime_pressure_plate",
            () -> new ModPressurePlateBlock(ModPressurePlateBlock.Sensitivity.EVERYTHING,
                    Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));

    public static final RegistryObject<Block> lemon_door = BLOCKS.register("lemon_door",
            () -> new ModWoodenDoor(Block.Properties.from(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> orange_door = BLOCKS.register("orange_door",
            () -> new ModWoodenDoor(Block.Properties.from(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> lime_door = BLOCKS.register("lime_door",
            () -> new ModWoodenDoor(Block.Properties.from(Blocks.OAK_DOOR)));
}
