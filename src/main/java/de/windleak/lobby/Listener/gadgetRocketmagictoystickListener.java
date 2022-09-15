package de.windleak.lobby.Listener;

import de.windleak.lobby.Main;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Objects;

public class gadgetRocketmagictoystickListener implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand() != null) {
            if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.RED + "Red Magic Toy Stick") && player.getItemInHand().getType() == Material.STICK) {
                spawnRocket(player, Color.RED);
            } else if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.YELLOW + "Yellow Magic Toy Stick") && player.getItemInHand().getType() == Material.STICK) {
                spawnRocket(player, Color.YELLOW);
            } else if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.GREEN + "Green Magic Toy Stick") && player.getItemInHand().getType() == Material.STICK) {
                spawnRocket(player, Color.GREEN);
            } else if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.AQUA + "Aqua Magic Toy Stick") && player.getItemInHand().getType() == Material.STICK) {
                spawnRocket(player, Color.AQUA);
            } else if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.BLUE + "Blue Magic Toy Stick") && player.getItemInHand().getType() == Material.STICK) {
                spawnRocket(player, Color.BLUE);
            }
        }
    }

    private void spawnRocket(Player player, Color color) {
        Location loc = (Location) player.getTargetBlock(null, 100).getLocation();
        loc.add(0.5, 1.5, 0.5);
        Firework firework = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fireworkmeta = firework.getFireworkMeta();
        fireworkmeta.addEffects(FireworkEffect.builder().withColor(color).with(FireworkEffect.Type.BALL_LARGE).build());
        fireworkmeta.addEffects(FireworkEffect.builder().withColor(color).with(FireworkEffect.Type.BALL_LARGE).build());
        fireworkmeta.setPower(1);
        firework.setFireworkMeta(fireworkmeta);
        player.getInventory().setItem(1, new ItemStack(Material.AIR, 1));
    }
}


// RED; YELLOW; GREEN; AQUA; BLUE