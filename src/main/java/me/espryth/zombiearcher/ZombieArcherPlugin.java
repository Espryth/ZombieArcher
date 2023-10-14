package me.espryth.zombiearcher;

import me.espryth.zombiearcher.entity.ZombieArcher;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ZombieArcherPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    getCommand("zombiearcher").setExecutor(
        (commandSender, command, label, strings) -> {
          final var player = (Player) commandSender;
          final var zombie = new ZombieArcher(player.getLocation());
          final var world = ((CraftWorld) player.getWorld()).getHandle();
          world.addFreshEntity(zombie);
          return true;
        }
    );
  }
}
