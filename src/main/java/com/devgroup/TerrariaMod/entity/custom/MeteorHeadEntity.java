package com.devgroup.TerrariaMod.entity.custom;

import com.devgroup.TerrariaMod.entity.ai.MeteorheadAttackGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class MeteorHeadEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(MeteorHeadEntity.class, EntityDataSerializers.BOOLEAN);

    public MeteorHeadEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 25.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0f)
                .add(Attributes.ATTACK_SPEED, 0.6f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeteorheadAttackGoal(this, 0.6D, false));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.6D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().loop("animation.meteorhead.walk"));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().playOnce("animation.meteorhead.idle"));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().playOnce("animation.meteorhead.attack"));
        }
        return PlayState.CONTINUE;
    }

        @Override
        public void registerControllers (AnimationData data){
            data.addAnimationController(new AnimationController(this, "controller",
                    10, this::predicate));
            data.addAnimationController(new AnimationController(this, "attackController",
                    0, this::attackPredicate));
        }

        @Override
        public AnimationFactory getFactory () {
            return factory;
        }
        protected void playStepSound (BlockPos pos, BlockState blockIn){
            this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 0.15F, 1.0F);
        }
        protected SoundEvent getAmbientSound () {
            return SoundEvents.BLAZE_AMBIENT;
        }
        protected SoundEvent getHurtSound (DamageSource damageSourceIn){
            return SoundEvents.BLAZE_HURT;
        }
        protected SoundEvent getDeathSound () {
            return SoundEvents.BLAZE_DEATH;
        }
        protected float getSoundVolume () {
            return 0.1F;
        }

        public void setAttacking ( boolean attacking){
            this.entityData.set(ATTACKING, attacking);
        }

        public boolean isAttacking () {
            return this.entityData.get(ATTACKING);
        }

        @Override
        protected void defineSynchedData () {
            super.defineSynchedData();
            this.entityData.define(ATTACKING, false);
        }
    }
