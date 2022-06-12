package behappy.hap.character.character.wwd.skill;

import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SkillB extends ActiveSkillBase {
    @Override
    public void onEnable() {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*this.skillTime,2,true));
    }

    @Override
    public void onClick() {
        if (this.coolTime==0) {
            for (Entity entity : player.getNearbyEntities(10,10,10)) {
                if (entity instanceof LivingEntity) {
                    LivingEntity all = (LivingEntity) entity;
                    all.getWorld().spawnParticle(Particle.FLAME, all.getLocation(), 400, 0.25, 3, 0.25, 0.1);
                    if (all instanceof Player) {
                        Player p = (Player) all;
                        p.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 0.6f, 1);
                    }

                    if (!player.equals(all)) {
                        if (all.getHealth() > 10) {
                            all.damage(10,player);
                        } else {
                            all.damage(all.getHealth(),player);
                        }
                        all.setFireTicks(20 * 8);
                    }
                }
            }

            this.onEnable();
            this.coolTime = this.time;
        }
    }

    public SkillB(Player p){
        this.player = p;
        this.id = 2;
        this.name = "뜨거운 화염 기운 발사";
        this.description = "주위의 적에게 화염기둥 발사\n5초간 이동속도 증가";
        this.time = 30;
        this.skillTime = 3;
        this.material = Material.FIRE_CHARGE;
    }
}

