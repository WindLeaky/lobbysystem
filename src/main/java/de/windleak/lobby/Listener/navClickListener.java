package de.windleak.lobby.Listener;

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


public class navClickListener implements Listener {
    private Inventory inventory;
    public static Inventory ffaservergui;
    public static Main main;

    public navClickListener(Main main2) {
        main = main2;


        //nav Inventory
        this.inventory = Bukkit.createInventory(null, 27, ChatColor.RED + "Navigator");

        // PvP Item
        ItemStack pvpitem = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta1 = pvpitem.getItemMeta();
        meta1.setDisplayName(ChatColor.DARK_GRAY + "1.18 FFA");

        List<String> lorepvp = new ArrayList<>();
        lorepvp.add(ChatColor.RESET + "" + ChatColor.AQUA + "Free for all fighting arena");
        meta1.setLore(lorepvp);

        pvpitem.setItemMeta(meta1);
        inventory.setItem(13, pvpitem);

        // Glass Panel Black item
        ItemStack glassitem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta meta2 = glassitem.getItemMeta();
        meta2.setDisplayName(" ");
        glassitem.setItemMeta(meta2);
        inventory.setItem(0, glassitem);
        inventory.setItem(1, glassitem);
        inventory.setItem(2, glassitem);
        inventory.setItem(3, glassitem);
        inventory.setItem(4, glassitem);
        inventory.setItem(5, glassitem);
        inventory.setItem(6, glassitem);
        inventory.setItem(7, glassitem);
        inventory.setItem(8, glassitem);
        inventory.setItem(9, glassitem);
        inventory.setItem(10, glassitem);
        inventory.setItem(11, glassitem);
        inventory.setItem(12, glassitem);
        inventory.setItem(14, glassitem);
        inventory.setItem(15, glassitem);
        inventory.setItem(16, glassitem);
        inventory.setItem(17, glassitem);
        inventory.setItem(18, glassitem);
        inventory.setItem(19, glassitem);
        inventory.setItem(20, glassitem);
        inventory.setItem(21, glassitem);
        inventory.setItem(22, glassitem);
        inventory.setItem(23, glassitem);
        inventory.setItem(24, glassitem);
        inventory.setItem(25, glassitem);
        inventory.setItem(26, glassitem);

        //ffaservergui

        this.ffaservergui = Bukkit.createInventory(null, 27, ChatColor.RED + "1.18 FFA");
    }


    public static void updateFFAGui() {


        ItemMeta tempM;
        ItemStack tempS;
        List<String> tempL;


        ffaservergui = Bukkit.createInventory(null, 27, ChatColor.YELLOW + "Join FFA");

        for (String ffa : Utilitys.startsWith(main.serverList, "ffaGameServer_")) {
            int serverId = Integer.parseInt(ffa.replace("ffaGameServer_", ""));
            tempS = new ItemStack(Material.NETHER_STAR, 1);
            tempM = tempS.getItemMeta();

            assert tempM != null;
            tempM.setDisplayName(ChatColor.GREEN + "Server " + (serverId + 1));

            tempL = new ArrayList<>();
            tempL.add(ChatColor.RESET + "" + ChatColor.WHITE + "" + main.playerCount.get("ffaGameServer_" + serverId) + " players online");

            tempM.setLore(tempL);
            tempS.setItemMeta(tempM);
            ffaservergui.setItem(serverId, tempS);
        }
    }

    @EventHandler
    public void ffaClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY + "1.18 FFA")) {
                updateFFAGui();
                event.setCancelled(true);
                player.openInventory(ffaservergui);

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Server ")) {
                event.setCancelled(true);
                player.closeInventory();

                int serverId = Integer.parseInt(event.getCurrentItem().getItemMeta().getDisplayName().replace(ChatColor.GREEN + "Server ", "")) - 1;

                player.sendMessage(Main.getPrefix() + ChatColor.GREEN + "Connecting to " + "FFA " + (serverId + 1) + "...");
                movePlayer(player, "ffaGameServer_" + serverId);
            }
        }
    }

    @EventHandler
    public void navClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();


        if (player.getItemInHand().getType() == Material.HEART_OF_THE_SEA) {
            player.openInventory(inventory);
        }


    }
}


