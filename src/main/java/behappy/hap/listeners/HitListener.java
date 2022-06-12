package behappy.hap.listeners;

import behappy.hap.character.character.invincible.Invincible;
import behappy.hap.character.character.minato.Minato;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static behappy.hap.character.base.CharacterBase.pAbility;

public class HitListener implements Listener {
    @EventHandler
    public void leftClick(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player t = (Player) e.getEntity();
            Player p = (Player) e.getDamager();
            if (pAbility.get(p.getName()) instanceof Invincible) {
                invinClick(p, t);
            }
        }
        if (e.getDamager() instanceof Player && pAbility.get(e.getDamager().getName()) instanceof Minato) {
            Player p = (Player) e.getDamager();
            LivingEntity t = (LivingEntity) e.getDamager();
            minClick(p,t);
        }
    }

    private void invinClick(Player p,Player t) {
        Invincible invincible = (Invincible) pAbility.get(p.getName());
        if (p.getItemInHand().getType()== Material.STICK) {
            invincible.skillA.onClick(t);
        } else if (p.getItemInHand().getType()==Material.BLAZE_ROD) {
            invincible.skillB.onClick(p,t);
        }
    }
    private void minClick(Player p,LivingEntity t) {
        Minato minato = (Minato) pAbility.get(p.getName());
        if (p.getItemInHand().getType()== Material.HEART_OF_THE_SEA) {
            minato.skillC.onClick(t);
        }
    }
}
