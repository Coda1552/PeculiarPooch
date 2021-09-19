package coda.peculiarpooch.common.init;

import coda.peculiarpooch.PeculiarPooch;
import coda.peculiarpooch.common.items.PPSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PPItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PeculiarPooch.MOD_ID);

    // Spawn Eggs
    public static final RegistryObject<Item> BORZOI_SPAWN_EGG = ITEMS.register("borzoi_spawn_egg", () -> new PPSpawnEggItem<>(PPEntities.BORZOI, 0xdda15e, 0x4a2a26, new Item.Properties().tab(ItemGroup.TAB_MISC)));
}
