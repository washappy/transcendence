package behappy.hap.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.jetbrains.annotations.NotNull;

import static behappy.hap.mangers.ArrayManager.playerData;
import static behappy.hap.mangers.FileManager.jsonFile;

public class LevelListener implements Listener {

    @EventHandler
    public void onLevelUp(@NotNull PlayerLevelChangeEvent e) {

        String playerName;
        playerName = e.getPlayer().getName();

        if (e.getNewLevel()>e.getOldLevel()) {
            for (int i =0; i < e.getNewLevel()-e.getOldLevel(); i++) {
                e.getPlayer().sendMessage(ChatColor.YELLOW + "Level Up!");
                playerData.get(playerName).hLevelUp();
                jsonFile.put(playerName,playerData.get(playerName).getMap());
            }
        }
    }
}
