package de.windleak.lobby;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilitys {
    public static List<String> startsWith(String[] s, String start) {
        List<String> o = new ArrayList<>();
        for (String n : Arrays.asList(s)) {
            if (n.startsWith(start)) {
                o.add(n);
            }
        }
        return o;
    }

    public static void updatePlayerCount(Main main, Player player, String[] servers) {
        List<String> toCheckServer = Utilitys.startsWith(servers, "lobby_");
        toCheckServer.addAll(Utilitys.startsWith(servers, "ffaGameServer_"));
        ByteArrayDataOutput out;

        for (String server : toCheckServer) {
            out = ByteStreams.newDataOutput();
            out.writeUTF("PlayerCount");
            out.writeUTF(server);
            player.sendPluginMessage(main, "BungeeCord", out.toByteArray());
        }
    }

    public static void getServer(Main main, Player player) {
        ByteArrayDataOutput out;
        out = ByteStreams.newDataOutput();
        out.writeUTF("GetServers");
        player.sendPluginMessage(main, "BungeeCord", out.toByteArray());
    }

    public static boolean isServerOnline(Integer port, String host) {
        try {
            Socket s = new Socket(host, port);
            s.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isServerOnline(SocketAddress sock) {
        try {
            Socket s = new Socket();
            s.connect(sock, 5); //good timeout is 10-20
            s.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void movePlayer(Player player, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        player.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", out.toByteArray());
    }
}
