package behappy.hap.listeners;

import behappy.hap.mangers.FileManager;
import behappy.hap.stats.human.Human;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import static behappy.hap.mangers.ArrayManager.humanss;
import static behappy.hap.mangers.ArrayManager.playerData;
import static behappy.hap.mangers.FileManager.jsonFile;
import static behappy.hap.mangers.FileManager.jsonList;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent e) {
        e.setJoinMessage((ChatColor.WHITE + "앗! 야생의 ") + (ChatColor.YELLOW + e.getPlayer().getName()) + (ChatColor.WHITE + "(이)가 들어왔다!"));
    }

}
