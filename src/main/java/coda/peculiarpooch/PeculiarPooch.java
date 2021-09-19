package coda.peculiarpooch;

import coda.peculiarpooch.client.ClientEvents;
import coda.peculiarpooch.common.entities.BorzoiEntity;
import coda.peculiarpooch.common.init.PPEntities;
import coda.peculiarpooch.common.init.PPItems;
import coda.peculiarpooch.common.init.PPSounds;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PeculiarPooch.MOD_ID)
public class PeculiarPooch {
    public static final String MOD_ID = "peculiarpooch";

    public PeculiarPooch() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        bus.addListener(this::registerClient);
        bus.addListener(this::registerCommon);
        bus.addListener(this::registerEntityAttributes);
        forgeBus.addListener(this::registerBiomes);

        PPItems.ITEMS.register(bus);
        PPEntities.ENTITIES.register(bus);
        PPSounds.SOUNDS.register(bus);
    }

    private void registerCommon(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(PPEntities.BORZOI.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
    }

    private void registerBiomes(BiomeLoadingEvent event) {
        if (event.getName().toString().equals("dark_forest") || event.getName().toString().equals("dark_forest_hills")) {
            event.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PPEntities.BORZOI.get(), 10, 1, 1));
        }
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(PPEntities.BORZOI.get(), BorzoiEntity.createAttributes().build());
    }

    private void registerClient(FMLClientSetupEvent event) {
         ClientEvents.init();
    }
}