package behappy.hap.listeners;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onDeath(org.bukkit.event.entity.PlayerDeathEvent e) {
        Player p = e.getPlayer();
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
    }
}
