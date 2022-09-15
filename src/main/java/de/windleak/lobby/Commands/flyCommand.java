package de.windleak.lobby.Commands;

import de.windleak.lobby.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class flyCommand implements CommandExecutor {
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int cooldownTime = 5;
        if(cooldowns.containsKey(sender.getName())) {
            long secondsLeft = ((cooldowns.get(sender.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
            if(secondsLeft>0) {

                sender.sendMessage(Main.getFlyPrefix() + ChatColor.RED + "You can't use this for another "+ secondsLeft +" seconds!");
                return true;
            }
        }
        cooldowns.put(sender.getName(), System.currentTimeMillis());
        Player player = (Player) sender;

        if(player.hasPermission("lobby.command.fly")){
            if(!player.getAllowFlight()) {
                player.sendMessage(Main.getFlyPrefix() + ChatColor.GREEN + "Enabled flying!");
                player.setAllowFlight(true);
            }
            else if(player.getAllowFlight()){
                player.sendMessage(Main.getFlyPrefix() + ChatColor.RED + "Disabled flying!");
                player.setAllowFlight(false);
            }
        }
        else if(!player.hasPermission("lobby.command.fly")){
            player.sendMessage(ChatColor.RED + "You don't have permissions to do that!");
        }
        return true;
    }
    }

