package com.devgroup.TerrariaMod.entity.ai;

import com.devgroup.TerrariaMod.entity.custom.MeteorHeadEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class MeteorheadAttackGoal extends MeleeAttackGoal {
    private MeteorHeadEntity entity;
    private int animCounter = 0;
    private int animTickLength = 20;

    public MeteorheadAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((MeteorHeadEntity) pMob);
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (pDistToEnemySqr <= this.getAttackReachSqr(pEnemy) && this.getTicksUntilNextAttack() <= 0) {
            if(entity != null) {
                entity.setAttacking(true);
                animCounter = 0;
            }
        }

        super.checkAndPerformAttack(pEnemy, pDistToEnemySqr);
    }

    @Override
    public void tick() {
        super.tick();
        if(entity.isAttacking()) {
            animCounter++;

            if(animCounter >= animTickLength) {
                animCounter = 0;
                entity.setAttacking(false);
            }
        }
    }


    @Override
    public void stop() {
        animCounter = 0;
        entity.setAttacking(false);
        super.stop();
    }
}