package com.devgroup.TerrariaMod.entity.custom.boss;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class EyeofCthulhuEntity extends Monster implements Enemy, IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final EntityDataAccessor<Integer> DATA_TARGET_A = SynchedEntityData.defineId(EyeofCthulhuEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_TARGET_B = SynchedEntityData.defineId(EyeofCthulhuEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_TARGET_C = SynchedEntityData.defineId(EyeofCthulhuEntity.class, EntityDataSerializers.INT);
    private static final List<EntityDataAccessor<Integer>> DATA_TARGETS = ImmutableList.of(DATA_TARGET_A, DATA_TARGET_B, DATA_TARGET_C);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EyeofCthulhuEntity.class, EntityDataSerializers.INT);
    public static final int CTHULHU_SPAWN_Y = 128;
    private static final int INVISIBLE_TICKS = 50;


    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(EyeofCthulhuEntity.class, EntityDataSerializers.BOOLEAN);
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
    };

    public EyeofCthulhuEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
        this.moveControl = new FlyingMoveControl(this, 2, true);
        this.setHealth(this.getMaxHealth());
        this.xpReward = 50;
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }
    protected PathNavigation createNavigation(Level p_186262_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_186262_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    public void tick() {
        this.noPhysics = false;
        super.tick();
        this.noPhysics = false;
        this.setNoGravity(true);
    }
    public void checkDespawn() {
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.discard();
        } else {
            this.noActionTime = 0;
        }
    }

    protected void customServerAiStep() {
        if (this.getInvisibleTicks() > 0) {
            int k2 = this.getInvisibleTicks() - 1;
            this.bossEvent.setProgress((float) (1.0F - (float)k2 / 50.0));
            if (k2 <= 0) {
            }
            this.setInvisibleTicks();
        } else {
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
    }



    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0f)
                .add(Attributes.ATTACK_SPEED, 0.6f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10)
                .add(Attributes.FLYING_SPEED, 2.4f)
                .add(Attributes.FOLLOW_RANGE, 100D)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new EyeofCthulhuEntity.CthulhuDoNothingGoal());
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.6D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));

    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
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


    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }

    @Override
    protected void defineSynchedData () {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(DATA_TARGET_A, 0);
        this.entityData.define(DATA_TARGET_B, 0);
        this.entityData.define(DATA_TARGET_C, 0);
        this.entityData.define(DATA_ID_INV, 0);
    }

    public void addAdditionalSaveData(CompoundTag p_31485_) {
        super.addAdditionalSaveData(p_31485_);
        p_31485_.putInt("Invis", this.getInvisibleTicks());
    }
    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        this.setInvisibleTicks();
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }

    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    public int getInvisibleTicks() {
        return this.entityData.get(DATA_ID_INV);
    }

    public void setInvisibleTicks() {
        this.entityData.set(DATA_ID_INV, 0);
    }

    public int getAlternativeTarget(int p_31513_) {
        return this.entityData.get(DATA_TARGETS.get(p_31513_));
    }
    public void setAlternativeTarget(int p_31455_, int p_31456_) {
        this.entityData.set(DATA_TARGETS.get(p_31455_), p_31456_);
    }


    class CthulhuDoNothingGoal extends Goal {
        public CthulhuDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return EyeofCthulhuEntity.this.getInvisibleTicks() > 0;
        }
    }
}
