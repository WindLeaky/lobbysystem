package de.windleak.lobby.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class featherflyClickListener implements Listener {
    @EventHandler
    public void onFeatherClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Enable/Disable Fly")) {

                    player.closeInventory();
                    player.performCommand("fly");


            }

        }
    }
}
