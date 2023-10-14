package me.espryth.zombiearcher.entity;

import io.papermc.paper.adventure.AdventureComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;

public class ZombieArcher
    extends Zombie
    implements RangedAttackMob {

  public ZombieArcher(final Location location) {
    super(
        EntityType.ZOMBIE,
        ((CraftWorld) location.getWorld()).getHandle()
    );

    setPos(location.getX(), location.getY(), location.getZ());
    setCanPickUpLoot(false);
    setAggressive(true);
    setCustomNameVisible(true);
    setCustomName(
        new AdventureComponent(
            MiniMessage.miniMessage().deserialize("<red>Zombie Archer")
        )
    );
    setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.BOW));
  }

  @Override
  protected void registerGoals() {
    super.registerGoals();
    this.goalSelector.addGoal(1, new RangedBowAttackGoal<>(this, 1, 20, 15));
  }

  @Override
  public void performRangedAttack(LivingEntity target, float pullProgress) {
    final var bow = getProjectile(getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
    final var arrow = ProjectileUtil.getMobArrow(this, bow, pullProgress);
    double d0 = target.getX() - this.getX();
    double d1 = target.getY(0.3333333333333333D) - arrow.getY();
    double d2 = target.getZ() - this.getZ();
    double d3 = Math.sqrt(d0 * d0 + d2 * d2);
    arrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float) (14 - level().getDifficulty().getId() * 4));
    level().addFreshEntity(arrow);
    playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
  }

}
