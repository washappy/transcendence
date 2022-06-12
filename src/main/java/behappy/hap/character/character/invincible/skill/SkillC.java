package behappy.hap.character.character.invincible.skill;

import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SkillC extends ActiveSkillBase {
    @Override
    public void onEnable() {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1,2,true));
        player.setMaximumNoDamageTicks(1);
    }

    public SkillC(Player p){
        this.player = p;
        this.id = 1;
        this.name = "Moojuck!";
        this.description = "걍 무적인디 워쭬건데이";
        this.material = Material.STICK;
    }
}
