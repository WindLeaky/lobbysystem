package de.windleak.lobby.Listener;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.windleak.lobby.Main;
import de.windleak.lobby.Utilitys;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static de.windleak.lobby.Utilitys.movePlayer;


public class lobbysswitchClickListener implements Listener {
    public Main main;

    private Inventory inventory;
    ItemStack switchitem = new ItemStack(Material.NETHER_STAR, 1);
    ItemMeta meta1 = switchitem.getItemMeta();

    ItemStack switchitem2 = new ItemStack(Material.NETHER_STAR, 1);
    ItemMeta meta3 = switchitem2.getItemMeta();

    ItemStack switchitem3 = new ItemStack(Material.NETHER_STAR, 1);
    ItemMeta meta4 = switchitem3.getItemMeta();

    public lobbysswitchClickListener(Main main2) {
        main = main2;


        Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
    }

    public void updateInventory() {
        ItemMeta tempM;
        ItemStack tempS;
        List<String> tempL;

        this.inventory = Bukkit.createInventory(null, 27, ChatColor.YELLOW + "Switch to a different lobby");

        for (String lobby : Utilitys.startsWith(main.serverList, "lobby_")) {
            int lobbyId = Integer.parseInt(lobby.replace("lobby_", ""));

            tempS = new ItemStack(Material.NETHER_STAR, 1);
            tempM = tempS.getItemMeta();

            assert tempM != null;
            tempM.setDisplayName(ChatColor.YELLOW + "Lobby " + (lobbyId + 1));

            tempL = new ArrayList<>();
            tempL.add(ChatColor.RESET + "" + ChatColor.WHITE + "" + main.playerCount.get("lobby_" + lobbyId) + " players online");

            if (main.getServer().getMotd().equals("lobby_" + lobbyId)) {
                tempL.add(ChatColor.RESET + "" + ChatColor.GREEN + "You");
            }

            tempM.setLore(tempL);
            tempS.setItemMeta(tempM);
            inventory.setItem(lobbyId, tempS);
        }
    }

    @EventHandler
    public void lobbyClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getItemInHand().getType() == Material.HONEYCOMB) {

            updateInventory();

            player.openInventory(inventory);
        }

    }

    @EventHandler
    public void ItemClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.YELLOW + "Lobby ")) {
                event.setCancelled(true);

                int lobbyId = Integer.parseInt(event.getCurrentItem().getItemMeta().getDisplayName().replace(ChatColor.YELLOW + "Lobby ", "")) - 1;
                MoveTo("lobby_" + lobbyId, event, "Lobby " + (lobbyId + 1));
            }
        }
    }

    private void MoveTo(String lobby, InventoryClickEvent event, String name) {
        Player player = (Player) event.getWhoClicked();
        player.sendMessage(Main.getPrefix() + ChatColor.GREEN + "Connecting to " + name + "...");
        movePlayer(player, lobby);
    }
}


