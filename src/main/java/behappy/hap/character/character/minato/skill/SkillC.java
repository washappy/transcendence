package behappy.hap.character.character.minato.skill;


import behappy.hap.character.base.ActiveSkillBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class SkillC extends ActiveSkillBase {
    @Override
    public void onClick(LivingEntity t){
        if (this.coolTime==0) {
            for(Player all : Bukkit.getOnlinePlayers()){
                all.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 0.6f, 1);
            }

            if (t.getHealth() > 16) {
                t.damage(16,player);
            } else {
                t.damage(t.getHealth(),player);
            }

            this.coolTime = this.time;

        } else {
            player.sendMessage("쿨타임 중 "+this.coolTime+"초 남음");
        }
    }
    public SkillC(Player p){
        this.player = p;
        this.id = 9;
        this.name = "나선환";
        this.description = "손바닥 위에 차크라를 강력하게 난회전시키며 구체 형태로 응축시켜, 적에게 타격하는 술법";
        this.material = Material.HEART_OF_THE_SEA;
        this.time = 20;
    }
}

