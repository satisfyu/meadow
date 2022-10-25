package net.satisfyu.meadow.entity.custom.cow.shearable.umbra;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.satisfyu.meadow.block.ModBlocks;
import net.satisfyu.meadow.entity.ModEntities;
import net.satisfyu.meadow.entity.custom.cow.shearable.ShearableCowEntity;
import net.satisfyu.meadow.item.ModItems;


public class UmbraCowEntity extends ShearableCowEntity {
    public UmbraCowEntity(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world, ModBlocks.UMBRA_WOOL);
    }

    @Override
    public CowEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return ModEntities.UMBRA_COW.create(serverWorld);
    }

}


