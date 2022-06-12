package behappy.hap.character.base;

import org.bukkit.entity.Player;

import java.util.HashMap;

public abstract class CharacterBase {

    public static HashMap<String, CharacterBase> pAbility = new HashMap<>();

    public String name = "";
    public String description = "";
    public Player player;

    public SkillBase skillA;
    public SkillBase skillB;
    public SkillBase skillC;

}
