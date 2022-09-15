package de.windleak.lobby.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    public static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }
   @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("nte.admin")){
            event.setFormat("§8[§cADMIN§8] §c%1$s§7: §f%2$s");
       }
        else if(player.hasPermission("nte.builder")){
            event.setFormat("§8[§2BUILDER§8] §2%1$s§7: §f%2$s");
        }
        else if(player.hasPermission("nte.moderator")){
            event.setFormat("§8[§3MOD§8] §3%1$s§7: §f%2$s");
        }
        else if(player.hasPermission("nte.simpplus")){
            event.setFormat("§8[§dSIMP+§8] §d%1$s§7: §f%2$s");
        }
        else if(player.hasPermission("nte.simp")){
            event.setFormat("§8[§dSIMP§8] §d%1$s§7: §f%2$s");
        }
        else if(player.hasPermission("nte.cairo")){
            event.setFormat("§8[§aCAIRO§8] §a%1$s§7: §f%2$s");
        }
        else if(player.hasPermission("nte.eefe")){
            event.setFormat("§8[§6EEFE§8] §6%1$s§7: §f%2$s");
        }
        else if(player.hasPermission("nte.dimi")){
            event.setFormat("§8[§9DIMI§8] §9%1$s§7: §f%2$s");
        }


        else if(player.hasPermission("nte.player")){
            event.setFormat("§7%1$s§7: §8%2$s");
        }
   }
}
