package behappy.hap.character.character.minato;

import behappy.hap.character.base.CharacterBase;
import behappy.hap.character.character.minato.skill.SkillA;
import behappy.hap.character.character.minato.skill.SkillB;
import behappy.hap.character.character.minato.skill.SkillC;
import org.bukkit.entity.Player;

public class Minato extends CharacterBase {
    public Minato(Player p) {
        this.player = p;
        this.name = "나미카제 미나토";
        this.description = "나뭇잎 마을 제 3대 호카게";
        this.skillA = new SkillA(p);
        this.skillB = new SkillB(p);
        this.skillC = new SkillC(p);
    }
}
