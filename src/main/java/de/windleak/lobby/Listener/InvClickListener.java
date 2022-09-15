package de.windleak.lobby.Listener;

import de.windleak.lobby.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;



public class InvClickListener implements Listener {
        @EventHandler
        public void InventoryClickEvent(InventoryClickEvent event){
                Player p = (Player) event.getWhoClicked();
                if(event.getCurrentItem()!=null) {

                    Material t = event.getCurrentItem().getType();
                        if (t != null || t != Material.AIR) {
                            event.setCancelled(true);
                        }
                    }
                }

        }



