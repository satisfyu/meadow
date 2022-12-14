package net.satisfyu.meadow.mixin.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.satisfyu.meadow.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public abstract class SheepMixin extends AnimalEntity {


    protected SheepMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = "interactMob",
            at = @At(value = "HEAD"),
            cancellable = true)

    private void addServerPackFinders(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);
        boolean bl;
        if (((bl = itemStack.isOf(Items.BUCKET)) || itemStack.isOf(ModItems.WOODEN_BUCKET)) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, bl ? ModItems.SHEEP_MILK.getDefaultStack() : ModItems.WOODEN_SHEEP_MILK.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            cir.setReturnValue(ActionResult.success(this.world.isClient));
        }
    }
}
