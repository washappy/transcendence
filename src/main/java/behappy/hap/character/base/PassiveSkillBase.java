package behappy.hap.character.base;

import org.bukkit.entity.Player;

public abstract class PassiveSkillBase extends SkillBase{
    protected Player player;
    public static void skillEffect(Player p){}

    @Override
    public void onClick() {
        onEnable();
    }
}
