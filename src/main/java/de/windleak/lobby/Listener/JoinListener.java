package de.windleak.lobby.Listener;


import de.windleak.lobby.Main;
import de.windleak.lobby.Utilitys;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class JoinListener implements Listener {
    public Main main;

    public JoinListener(Main main2) {
        main = main2;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (main.getServer().getOnlinePlayers().size() == 1) {
            Utilitys.getServer(main, player);
        }

        // Lobby Items
        //Navigator item

        ItemStack item1 = new ItemStack(Material.HEART_OF_THE_SEA, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(ChatColor.BLUE + "Navigator");
        item1.setItemMeta(meta1);
        player.getInventory().setItem(0, item1);

        ItemStack item2 = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(ChatColor.GOLD + "Gadgets");
        item2.setItemMeta(meta2);
        player.getInventory().setItem(4, item2);

        //lobby switcher item
        ItemStack item3 = new ItemStack(Material.HONEYCOMB, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName(ChatColor.YELLOW + "Lobby Switcher");
        item3.setItemMeta(meta3);
        player.getInventory().setItem(8, item3);

        //lobby switcher item
        ItemStack item4 = new ItemStack(Material.FEATHER, 1);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName(ChatColor.WHITE + "Enable/Disable Fly");
        item4.setItemMeta(meta4);
        if(player.hasPermission("lobby.command.fly")) {
            player.getInventory().setItem(35, item4);
        }


        player.sendMessage(Main.getPrefix() + "Hello and welcome!");
        player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 0.7F, 0.7F);
        player.getInventory().setHeldItemSlot(0);
        player.setHealth(20);
        player.setFoodLevel(20);

        Location location = new Location(Bukkit.getWorld("World"), 735.434, 23, -1012.430);
        player.teleport(location);
        player.setLevel(2022);
        player.setPlayerListHeaderFooter(ChatColor.YELLOW + "CloudyMC.eu Network", "footer");

        //TABLIST

        String motd = main.getServer().getMotd();

        int lobbyId = Integer.parseInt(motd.replace("lobby_", ""));

        String tablistheader = ChatColor.YELLOW + "www.CloudyMC.eu - Lobby " + (lobbyId +1) + "\n  ";
        String tablistfooter = "\n  " + ChatColor.GRAY + "Add your friends or create parties" + "\n  " + ChatColor.GRAY + "with " + ChatColor.LIGHT_PURPLE + "/friends " + ChatColor.GRAY
                + "and " + ChatColor.LIGHT_PURPLE + "/party";
        player.setPlayerListHeaderFooter(tablistheader, tablistfooter);




        // RANK FORMAT


        if (player.hasPermission("nte.admin")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§cADMIN§8] §c" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§cADMIN§8] §c" + player.getName());
        } else if (player.hasPermission("nte.builder")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§2BUILDER§8] §2" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§2BUILDER§8] §2" + player.getName());
        } else if (player.hasPermission("nte.moderator")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§3MOD§8] §3" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§3MOD§8] §3" + player.getName());
        } else if (player.hasPermission("nte.cairo")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§aCAIRO§8] §a" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§aCAIRO§8] §a" + player.getName());
        } else if (player.hasPermission("nte.simp")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§dSIMP§8] §d" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§dSIMP§8] §d" + player.getName());
        } else if (player.hasPermission("nte.simpplus")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§dSIMP+§8] §d" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§dSIMP+§8] §d" + player.getName());
        } else if (player.hasPermission("nte.eefe")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§6EEFE§8] §6" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§6EEFE§8] §6" + player.getName());
        } else if (player.hasPermission("nte.dimi")) {
            event.setJoinMessage(Main.getPrefix() + "§8[§9DIMI§8] §9" + player.getName() + ChatColor.GRAY + " joined the lobby!");
            player.sendTitle(ChatColor.WHITE + "Welcome!", "§8[§9DIMI§8] §9" + player.getName());
        } else if (player.hasPermission("nte.player")) {
            event.setJoinMessage("");
            player.sendTitle(ChatColor.WHITE + "Welcome!", ChatColor.GRAY + "" + player.getName());

        } else{
            event.setJoinMessage("");
            player.sendTitle(ChatColor.WHITE + "Welcome!", ChatColor.GRAY + "" + player.getName());
        }
    }
}
