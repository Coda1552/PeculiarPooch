package coda.peculiarpooch.common.init;

import coda.peculiarpooch.PeculiarPooch;
import coda.peculiarpooch.common.entities.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PPEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, PeculiarPooch.MOD_ID);

    public static final RegistryObject<EntityType<BorzoiEntity>> BORZOI = create("borzoi", EntityType.Builder.of(BorzoiEntity::new, EntityClassification.CREATURE).sized(0.65f, 0.65f));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(PeculiarPooch.MOD_ID + "." + name));
    }
}
