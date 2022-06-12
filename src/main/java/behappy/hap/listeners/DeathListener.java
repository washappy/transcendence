package behappy.hap.listeners;

import behappy.hap.character.character.wwd.WWD;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import static behappy.hap.character.base.CharacterBase.pAbility;

public class DeathListener implements Listener {
    @EventHandler
    public void onKill(EntityDeathEvent e) throws InterruptedException {
        LivingEntity entity = e.getEntity();
        Player player = e.getEntity().getKiller();
        if (player!=null) {
            if (entity instanceof Player) {
                if (pAbility.get(player.getName()) instanceof WWD) {
                    WWD wwd = (WWD) pAbility.get(player.getName());
                    wwd.skillC.onClick();
                }
                entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
            }
        }
    }
}
