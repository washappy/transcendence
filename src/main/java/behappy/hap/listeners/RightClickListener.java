package behappy.hap.listeners;

import behappy.hap.GUI.MainUI;
import behappy.hap.character.character.invincible.Invincible;
import behappy.hap.character.character.minato.Minato;
import behappy.hap.character.character.wwd.WWD;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static behappy.hap.character.base.CharacterBase.pAbility;

public class RightClickListener implements Listener {
    @EventHandler
    public void rightClick(PlayerInteractEvent e) throws InterruptedException {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if (a==Action.RIGHT_CLICK_AIR||a==Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand().getType()== Material.NETHER_STAR) {
                new MainUI(p);
            }
            if (pAbility.get(p.getName()) instanceof WWD) {
                wwdCilck(p,e);
            } else if (pAbility.get(p.getName()) instanceof Minato) {
                minatoClick(p,e);
            } else if (pAbility.get(p.getName()) instanceof Invincible) {
                invinClick(p,e);
            }
        }
    }

    private void wwdCilck(Player p,PlayerInteractEvent e) throws InterruptedException {
        WWD wwd = (WWD) pAbility.get(p.getName());
        if (p.getItemInHand().getType()== Material.STICK) {
            e.setCancelled(true);
            wwd.skillA.onClick();
        } else if (p.getItemInHand().getType()== Material.FIRE_CHARGE) {
            e.setCancelled(true);
            wwd.skillB.onClick();
        }
    }

    private void minatoClick(Player p,PlayerInteractEvent e) {
        Minato minato = (Minato) pAbility.get(p.getName());
        if (p.getItemInHand().getType()==Material.WOODEN_SWORD||p.getItemInHand().getType()==Material.STONE_SWORD||p.getItemInHand().getType()==Material.IRON_SWORD||p.getItemInHand().getType()==Material.GOLDEN_SWORD||p.getItemInHand().getType()==Material.DIAMOND_SWORD||p.getItemInHand().getType()==Material.NETHERITE_SWORD) {
            minato.skillB.onClick(p);
        } else if(p.getItemInHand().getType()==Material.ARROW) {
            e.setCancelled(true);
            minato.skillA.onClick(p);
        }
    }
    private void invinClick(Player p,PlayerInteractEvent e) {
        Invincible invincible = (Invincible) pAbility.get(p.getName());
        if (p.getItemInHand().getType()==Material.STICK) {
            e.setCancelled(true);
            invincible.skillC.onEnable();
        }
    }
}
