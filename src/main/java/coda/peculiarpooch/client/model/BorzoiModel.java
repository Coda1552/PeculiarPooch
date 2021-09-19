package coda.peculiarpooch.client.model;

import coda.peculiarpooch.common.entities.BorzoiEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BorzoiModel<T extends BorzoiEntity> extends AgeableModel<T> {
    public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer armRight;
    public ModelRenderer armLeft;
    public ModelRenderer furLeft;
    public ModelRenderer furRight;
    public ModelRenderer legLeft;
    public ModelRenderer legRight;
    public ModelRenderer tail;
    public ModelRenderer head;
    public ModelRenderer earRight;
    public ModelRenderer earLeft;
    public ModelRenderer tongue;

    public BorzoiModel() {
        super(true, 12F, 2.5f);
        this.texWidth = 64;
        this.texHeight = 32;
        this.legRight = new ModelRenderer(this, 5, 2);
        this.legRight.setPos(-1.5F, 2.5F, 5.5F);
        this.legRight.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 46, 8);
        this.tail.setPos(0.0F, 0.5F, 6.5F);
        this.tail.addBox(-1.5F, -2.0F, 0.0F, 3.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.armLeft = new ModelRenderer(this, 14, 2);
        this.armLeft.setPos(1.5F, 2.5F, -5.5F);
        this.armLeft.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.earRight = new ModelRenderer(this, 24, 14);
        this.earRight.mirror = true;
        this.earRight.setPos(-1.5F, -2.0F, 0.5F);
        this.earRight.addBox(-1.0F, -1.0F, -1.5F, 1.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(earRight, 0.0F, 0.0F, 0.2617993877991494F);
        this.tongue = new ModelRenderer(this, 52, 26);
        this.tongue.mirror = true;
        this.tongue.setPos(1.5F, 0.0F, -8.5F);
        this.tongue.addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.furRight = new ModelRenderer(this, 37, 21);
        this.furRight.setPos(-2.0F, 2.5F, -1.0F);
        this.furRight.addBox(0.0F, 0.0F, -3.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 14);
        this.body.setPos(0.0F, 12.5F, 0.0F);
        this.body.addBox(-2.5F, -2.5F, -6.5F, 5.0F, 5.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.furLeft = new ModelRenderer(this, 37, 21);
        this.furLeft.mirror = true;
        this.furLeft.setPos(2.0F, 2.5F, -1.0F);
        this.furLeft.addBox(0.0F, 0.0F, -3.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 15);
        this.neck.setPos(0.0F, 12.0F, -6.5F);
        this.neck.addBox(-1.5F, -7.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.legLeft = new ModelRenderer(this, 5, 2);
        this.legLeft.setPos(1.5F, 2.5F, 5.5F);
        this.legLeft.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.armRight = new ModelRenderer(this, 14, 2);
        this.armRight.setPos(-1.5F, 2.5F, -5.5F);
        this.armRight.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 24, 8);
        this.head.setPos(0.0F, -7.0F, -0.5F);
        this.head.addBox(-1.5F, -3.0F, -13.5F, 3.0F, 3.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.earLeft = new ModelRenderer(this, 24, 14);
        this.earLeft.setPos(1.5F, -2.0F, 0.5F);
        this.earLeft.addBox(0.0F, -1.0F, -1.5F, 1.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(earLeft, 0.0F, 0.0F, -0.2617993877991494F);
        this.body.addChild(this.legRight);
        this.body.addChild(this.tail);
        this.body.addChild(this.armLeft);
        this.head.addChild(this.earRight);
        this.head.addChild(this.tongue);
        this.body.addChild(this.furRight);
        this.body.addChild(this.furLeft);
        this.body.addChild(this.legLeft);
        this.body.addChild(this.armRight);
        this.neck.addChild(this.head);
        this.head.addChild(this.earLeft);
    }

    @Override
    protected Iterable<ModelRenderer> headParts() {
        return ImmutableList.of(neck);
    }

    @Override
    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of(body);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
