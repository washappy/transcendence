package behappy.hap.character.character.invincible.skill;

import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SkillB extends ActiveSkillBase {
    @Override
    public void onClick(Player m, Player p){
        if (this.coolTime==0) {
            for(Player all : Bukkit.getOnlinePlayers()){
                all.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 0.6f, 1);
            }

            p.kickPlayer(m.getName()+" : 나가");
            this.coolTime = this.time;

        } else {
            player.sendMessage("쿨타임 중 "+this.coolTime+"초 남음");
        }
    }
    public SkillB(Player p){
        this.player = p;
        this.id = 5;
        this.name = "나가";
        this.description = "너 밴";
        this.material = Material.BLAZE_ROD;
        this.time = 100;
    }
}
