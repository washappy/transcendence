package behappy.hap.character.character.invincible.skill;

import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SkillA extends ActiveSkillBase {
    @Override
    public void onClick(Player p) {
        if (this.coolTime==0) {
            for(Player all : Bukkit.getOnlinePlayers()){
                all.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.6f, 1);
            }

            p.setHealth(0.0);
            this.coolTime = this.time;

        } else {
            player.sendMessage("쿨타임 중 "+this.coolTime+"초 남음");
        }
    }

    public SkillA(Player p){
        this.player = p;
        this.id = 4;
        this.name = "One punch";
        this.description = "한대";
        this.time = 120;
        this.material = Material.STICK;
    }
}
