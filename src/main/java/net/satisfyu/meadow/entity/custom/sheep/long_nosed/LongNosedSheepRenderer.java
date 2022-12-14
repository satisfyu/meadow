package net.satisfyu.meadow.entity.custom.sheep.long_nosed;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.util.Identifier;
import net.satisfyu.meadow.MeadowClient;
import net.satisfyu.meadow.entity.custom.EyeBlinkRenderer;
import net.satisfyu.meadow.entity.custom.sheep.MeadowSheepWoolFeatureRenderer;

import static net.satisfyu.meadow.Meadow.MOD_ID;

public class LongNosedSheepRenderer extends MobEntityRenderer<LongNosedSheepEntity, SheepEntityModel<LongNosedSheepEntity>> {

    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/sheep/long_nosed_sheep.png");

    public LongNosedSheepRenderer(EntityRendererFactory.Context context) {
        super(context, new SheepEntityModel<>(context.getPart(MeadowClient.LONG_NOSED_SHEEP_MODEL_LAYER)), 0.7f);
        this.addFeature(new EyeBlinkRenderer<>(this, "long_nosed_sheep", "sheep"));
        this.addFeature(new MeadowSheepWoolFeatureRenderer<>(this, context.getModelLoader(), "long_nosed", MeadowClient.LONG_NOSED_SHEEP_FUR));
    }

    @Override
    public Identifier getTexture(LongNosedSheepEntity entity) {
        return TEXTURE;
    }
}
