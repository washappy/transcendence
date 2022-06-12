package behappy.hap.listeners;

import behappy.hap.character.character.minato.Minato;
import behappy.hap.character.character.minato.skill.SkillA;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static behappy.hap.character.base.CharacterBase.pAbility;

public class LeftClickListener implements Listener {
    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action a = event.getAction();

        if (a==Action.LEFT_CLICK_AIR||a==Action.LEFT_CLICK_BLOCK) {
            if (pAbility.get(p.getName()) instanceof Minato) {
                if (p.getItemInHand().getType()== Material.ARROW) {
                    SkillA skillA = (SkillA) pAbility.get(p.getName()).skillA;
                    skillA.onLeftClick();
                    p.setItemInHand(new ItemStack(Material.ARROW,p.getItemInHand().getAmount()-1));
                }
            }
        }
    }
}
