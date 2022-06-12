package behappy.hap.character.character.minato.skill;

import behappy.hap.character.base.ActiveSkillBase;
import behappy.hap.material.FIFO;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SkillA extends ActiveSkillBase {
    private FIFO<Arrow> thrownArrows = new FIFO<>();

    @Override
    public void onClick(Player p) {
        if (this.coolTime==0) {
            for(Player all : Bukkit.getOnlinePlayers()){
                all.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 0.6f, 2);
            }
            Vector direction = p.getLocation().getDirection();
            if (!thrownArrows.isEmpty()) {
                Arrow arrow = thrownArrows.pop();
                arrow.remove();
                p.teleport(arrow.getLocation().setDirection(direction));
            }

            p.getWorld().spawnParticle(Particle.GLOW, player.getLocation(), 100, 0.5, 1, 0.5);

            this.coolTime = this.time;

        } else {
            player.sendMessage("쿨타임 중 "+this.coolTime+"초 남음");
        }
    }

    public void onLeftClick() {
        Arrow arrow = player.launchProjectile(Arrow.class);
        arrow.setKnockbackStrength(3);
        arrow.setGravity(true);
        arrow.setPickupRule(AbstractArrow.PickupRule.DISALLOWED);
        arrow.setVelocity(player.getLocation().getDirection().multiply(5));
        thrownArrows.add(arrow);
    }

    public SkillA(Player p){
        this.player = p;
        this.id = 7;
        this.name = "비뢰신의 술";
        this.description = "특수한 술식으로 마킹된 공간으로 술자를 역소환하는 술법";
        this.time = 5;
        this.material = Material.IRON_SWORD;
    }
}