package de.windleak.lobby.Listener;

import de.windleak.lobby.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlaceBreakListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
            if (!player.isOp()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!player.isOp()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDoorInteract(PlayerInteractEvent event) {
        Action action = event.getAction();
        Block clicked = event.getClickedBlock();
        Player player = event.getPlayer();
            if (!player.isOp()) {
                if (action == Action.RIGHT_CLICK_BLOCK && clicked.getType() == Material.ACACIA_DOOR) {
                    player.sendMessage(ChatColor.RED + "You can't use that!");
                    event.setCancelled(true);
                }
            }
        }
    }
