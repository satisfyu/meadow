package net.satisfyu.meadow.entity.custom.sheep.inky;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.satisfyu.meadow.Meadow;
import net.satisfyu.meadow.block.ModBlocks;
import net.satisfyu.meadow.entity.ModEntities;
import net.satisfyu.meadow.entity.custom.sheep.MeadowSheepEntity;

public class InkySheepEntity extends MeadowSheepEntity {
    public InkySheepEntity(EntityType<? extends SheepEntity> entityType, World world) {
        super(entityType, world, ModBlocks.INKY_WOOL, new Identifier(Meadow.MOD_ID, "entities/sheep/inky"));
    }

    @Override
    public SheepEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return ModEntities.INKY_SHEEP.create(serverWorld);
    }
}
