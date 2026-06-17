package org.gobers.teftercraft.item.custom;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class KaboomItem extends Item {
    public KaboomItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        if (level.isClientSide()) return super.useOn(context);
        ((ServerLevel) level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK,context.getLevel().getBlockState(context.getClickedPos())),context.getClickedPos().getX()+0.5
                ,context.getClickedPos().getY()+1,context.getClickedPos().getZ() + 0.5,50,0,0,0,1.5f);


        level.explode(context.getPlayer(),context.getClickedPos().getX(),context.getClickedPos().getY(),context.getClickedPos().getZ(),5, Level.ExplosionInteraction.MOB);

        return InteractionResult.SUCCESS;
    }

    @Override
    public float getAttackDamageBonus(Entity entity, float damage, DamageSource damageSource) {

        var pos = entity.getOnPos();
        Level level = entity.level();


        if (level instanceof ServerLevel sLevel){
            entity.kill(sLevel);
            level.explode(entity,pos.getX(),pos.getY(),pos.getZ(),5,true, Level.ExplosionInteraction.MOB);
        }

        return 0f;
    }
}
