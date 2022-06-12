package behappy.hap.character.character.invincible;

import behappy.hap.character.base.CharacterBase;
import behappy.hap.character.character.invincible.skill.SkillA;
import behappy.hap.character.character.invincible.skill.SkillB;
import behappy.hap.character.character.invincible.skill.SkillC;
import org.bukkit.entity.Player;

public class Invincible extends CharacterBase {
    public Invincible(Player p){
        this.player = p;
        this.name = "최강무적";
        this.description = "뭘봐니봐";
        this.skillA = new SkillA(p);
        this.skillB = new SkillB(p);
        this.skillC = new SkillC(p);
    }
}
