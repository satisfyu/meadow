package net.satisfyu.meadow.entity.custom.chicken.chicken2;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.satisfyu.meadow.entity.ModEntities;

public class Chicken2Entity extends ChickenEntity {
    public Chicken2Entity(EntityType<? extends ChickenEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Chicken2Entity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return ModEntities.CHICKEN2.create(serverWorld);
    }
}
