package de.windleak.lobby.Commands;

import de.windleak.lobby.Listener.navClickListener;
import de.windleak.lobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ffaguiCommand implements CommandExecutor {
    private Inventory ffaservergui;
    private Main main;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        navClickListener.updateFFAGui();
        player.openInventory(navClickListener.ffaservergui);
        return false;
    }
}