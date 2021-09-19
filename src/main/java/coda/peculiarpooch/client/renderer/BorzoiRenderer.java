package coda.peculiarpooch.client.renderer;

import coda.peculiarpooch.PeculiarPooch;
import coda.peculiarpooch.client.model.BorzoiModel;
import coda.peculiarpooch.common.entities.BorzoiEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BorzoiRenderer extends MobRenderer<BorzoiEntity, BorzoiModel<BorzoiEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(PeculiarPooch.MOD_ID, "textures/entity/borzoi.png");

    public BorzoiRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BorzoiModel<>(), 0.45F);
    }

    @Override
    protected float getBob(BorzoiEntity p_77044_1_, float p_77044_2_) {
        return p_77044_1_.getTailAngle();
    }

    public ResourceLocation getTextureLocation(BorzoiEntity entity) {
        return TEXTURE;
    }
}
