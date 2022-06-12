package behappy.hap.character.character.wwd.skill;

import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SkillC extends ActiveSkillBase {
    @Override
    public void onEnable() {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()+5);
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,20*1,6,true));
    }

    @Override
    public void skillEffect() {
        player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 250, 0.5, 1, 0.5,0.1);
    }

    @Override
    public void onClick() {
        onEnable();
    }


    public SkillC(Player p) {
        this.player = p;
        this.id = 3;
        this.name = "영혼흡수";
        this.description = "플레이어 킬 시 체력 5추가";
        this.material = Material.SKELETON_SKULL;
    }
}