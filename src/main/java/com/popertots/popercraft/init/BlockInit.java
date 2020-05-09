package com.popertots.popercraft.init;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.objects.blocks.CitrusSaplingBlock;
import com.popertots.popercraft.objects.blocks.EndriumBlock;
import com.popertots.popercraft.world.feature.LemonTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
            Popercraft.MOD_ID);

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

    public static final RegistryObject<Block> citrus_leaves = BLOCKS.register("citrus_leaves", () -> new LeavesBlock(
            Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> lemon_log = BLOCKS.register("lemon_log", () -> new LogBlock(MaterialColor.WOOD,
            Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> lemon_planks = BLOCKS.register("lemon_planks", () -> new Block(
            Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> lemon_sapling = BLOCKS.register("lemon_sapling", () -> new CitrusSaplingBlock( () -> new LemonTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

}
