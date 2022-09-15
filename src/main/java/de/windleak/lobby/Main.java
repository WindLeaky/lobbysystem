package de.windleak.lobby;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import de.windleak.lobby.Commands.ffaguiCommand;
import de.windleak.lobby.Commands.flyCommand;
import de.windleak.lobby.Listener.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public final class Main extends JavaPlugin implements PluginMessageListener {
    public Map<String, Boolean> onlineServer = new HashMap<>();
    public Map<String, Integer> playerCount = new HashMap<>();
    public Map<UUID, Scoreboard> Playerscoreboard;
    public String[] serverList;

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("Plugin wird aktiviert");
        listenerRegistration();
        commandRegistration();


        Playerscoreboard = new HashMap<>();
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Plugin wird deaktiviert");

        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);

    }

    public static String getPrefix() {
        return ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Lobby" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
    }

    public static String getWarModePrefix(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "WARMODE" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
    }
    public static String getGadgetPrefix(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Gadgets" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
    }
    public static String getFlyPrefix(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Fly" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
    }


    public void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(this), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new InvClickListener(), this);
        pluginManager.registerEvents(new InvDropListener(), this);
        pluginManager.registerEvents(new navClickListener(this), this);
        pluginManager.registerEvents(new lobbysswitchClickListener(this), this);
        pluginManager.registerEvents(new DamageListener(), this);
        pluginManager.registerEvents(new HungerListener(), this);
        pluginManager.registerEvents(new PlaceBreakListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new GadgetClickListener(), this);
        pluginManager.registerEvents(new featherflyClickListener(), this);
        pluginManager.registerEvents(new gadgetRocketmagictoystickListener(), this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() != 0) {
                    Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);

                    Utilitys.getServer(Main.this, player);
                }
            }
        }, 20L, 20 * 10);
    }

    public void commandRegistration() {
        getCommand("fly").setExecutor(new flyCommand());
        getCommand("playffa").setExecutor(new ffaguiCommand());
    }


    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        if (!channel.equals("BungeeCord")) {
            return;
        }
        String subChannel = in.readUTF();
        if (subChannel.equals("PlayerCount")) {
            String server = in.readUTF();
            Integer players = in.readInt();
            playerCount.put(server, players);
        }
        if (subChannel.equals("GetServers")) {
            serverList = in.readUTF().split(", ");;

            Utilitys.updatePlayerCount(this, player, serverList);
        }
    }
}



