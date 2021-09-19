package coda.peculiarpooch.client;

import coda.peculiarpooch.PeculiarPooch;
import coda.peculiarpooch.client.renderer.BorzoiRenderer;
import coda.peculiarpooch.common.init.PPEntities;
import coda.peculiarpooch.common.items.PPSpawnEggItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PeculiarPooch.MOD_ID)
public class ClientEvents {

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(PPEntities.BORZOI.get(), BorzoiRenderer::new);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((PPSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (PPSpawnEggItem e : PPSpawnEggItem.SPAWN_EGGS) handler.register(eggColor, e);
    }
}
