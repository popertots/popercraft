package com.popertots.popercraft;

import com.popertots.popercraft.init.BiomeInit;
import com.popertots.popercraft.init.BlockInit;
import com.popertots.popercraft.init.ItemInit;
import com.popertots.popercraft.world.gen.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Popercraft.MOD_ID)
@Mod.EventBusSubscriber(modid = Popercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Popercraft
{
	public static final String MOD_ID = "popercraft";
    public static Popercraft instance;
	
	private static final Logger LOGGER = LogManager.getLogger();
    
    
    public Popercraft() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream()
                .map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(PopercraftItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("onRegisterItems: " + BlockInit.BLOCKS.getEntries().size());
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        BiomeInit.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	mithrilOreGen.generateOre();
    	malachiteOreGen.generateOre();
        orichalcumOreGen.generateOre();
        endriumOreGen.generateOre();
//        LemonTreeGen.generateTrees();
//        OrangeTreeGen.generateTrees();
//        LimeTreeGen.generateTrees();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
    
    
    @SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {

	}

    public static class PopercraftItemGroup extends ItemGroup {
        public static final ItemGroup instance = new PopercraftItemGroup(ItemGroup.GROUPS.length, "Popercraft");

        private PopercraftItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.malachite_ingot.get());
        }
    }
}
