package de.windleak.lobby.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;


public class InvDropListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();

            if(event.getItemDrop().getItemStack().getType() != Material.AIR){

                event.setCancelled(true);

            }
        }

    }

