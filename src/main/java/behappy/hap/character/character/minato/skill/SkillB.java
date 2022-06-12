package behappy.hap.character.character.minato.skill;


import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.*;
import org.bukkit.entity.Player;

public class SkillB extends ActiveSkillBase {
    @Override
    public void onClick(Player p){
        if (this.coolTime==0) {
            p.getWorld().spawnParticle(Particle.GLOW, player.getLocation(), 25, 0.5, 1, 0.5, 0.7);
            Location location = null;
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 0.6f, 2);
                if (!all.equals(p)) {
                    if (location == null || player.getLocation().distance(all.getLocation()) < player.getLocation().distance(location)) {
                        location = all.getLocation();
                    }

                    location.subtract(location.getDirection()).subtract(location.getDirection());

                    if (location != null) {
                        player.teleport(location);
                    }
                    this.coolTime = this.time;
                }
            }
        }
    }

    public SkillB(Player p){
        this.player = p;
        this.id = 8;
        this.name = "비뢰신의 술법";
        this.description = "사람에게 술식을 새겼다.";
        this.time = 10;
        this.material = Material.ARROW;
    }
}