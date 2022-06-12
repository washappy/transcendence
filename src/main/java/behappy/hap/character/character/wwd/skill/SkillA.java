package behappy.hap.character.character.wwd.skill;

import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SkillA extends ActiveSkillBase {
    @Override
    public void onEnable(){
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,20*this.skillTime,4,false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,20*this.skillTime,3,false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,20*this.skillTime,5,false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,20*2,255,false));
    }

    @Override
    public void skillEffect() {
        player.getWorld().spawnParticle(Particle.SLIME, player.getLocation(), 200, 0.1, 1, 0.1,0.1);
        for(Player all : Bukkit.getOnlinePlayers()){
            all.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 0.6f, 1);
        }
    }


    public SkillA(Player p){
        this.player = p;
        this.id = 1;
        this.name = "*울트라 변신*";
        this.description = "모든 데미지 두배\n이동속도 반감\n모든 넉백 무효화";
        this.time = 200; //쿨타임 200초
        this.skillTime = 30;
        this.material = Material.STICK;
        player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1);
    }
}

