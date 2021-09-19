package coda.peculiarpooch.common.init;

import coda.peculiarpooch.PeculiarPooch;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PPSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PeculiarPooch.MOD_ID);

    public static final RegistryObject<SoundEvent> BORZOI_AMBIENT = SOUNDS.register("borzoi_ambient", () -> new SoundEvent(new ResourceLocation(PeculiarPooch.MOD_ID, "borzoi.ambient")));
    public static final RegistryObject<SoundEvent> BORZOI_HURT = SOUNDS.register("borzoi_hurt", () -> new SoundEvent(new ResourceLocation(PeculiarPooch.MOD_ID, "borzoi.hurt")));
    public static final RegistryObject<SoundEvent> BORZOI_DEATH = SOUNDS.register("borzoi_death", () -> new SoundEvent(new ResourceLocation(PeculiarPooch.MOD_ID, "borzoi.death")));
}
