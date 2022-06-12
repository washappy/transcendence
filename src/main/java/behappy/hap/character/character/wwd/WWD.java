package behappy.hap.character.character.wwd;

import behappy.hap.character.base.CharacterBase;
import behappy.hap.character.character.wwd.skill.SkillA;
import behappy.hap.character.character.wwd.skill.SkillB;
import behappy.hap.character.character.wwd.skill.SkillC;
import org.bukkit.entity.Player;

public class WWD extends CharacterBase {
    public WWD(Player p){
        this.player = p;
        this.name = "워때이 워쩔 DRAGON";
        this.description = "워때이 워쩔한 드래곤이다.\n울트라 변신과 엄청난 스킬로 적들을 휩쓸어버린다.";
        this.skillA = new SkillA(p);
        this.skillB = new SkillB(p);
        this.skillC = new SkillC(p);
    }
}
