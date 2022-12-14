package net.satisfyu.meadow.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.satisfyu.meadow.item.ModItems;

public class WoodenPowderSnowBucket extends PowderSnowBucketItem {
    public WoodenPowderSnowBucket(Block block, SoundEvent placeSound, Settings settings) {
        super(block, placeSound, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult actionResult = super.useOnBlock(context);
        PlayerEntity playerEntity = context.getPlayer();
        if (actionResult.isAccepted() && playerEntity != null && !playerEntity.isCreative()) {
            Hand hand = context.getHand();
            playerEntity.setStackInHand(hand, ModItems.WOODEN_BUCKET.getDefaultStack());
        }
        return actionResult;
    }
}
