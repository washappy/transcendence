package behappy.hap.character.base;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public abstract class SkillBase {

    protected Player player;
    public String name = "";
    public String description = "";
    public int id = 0;
    protected int time;
    protected int skillTime;
    protected int coolTime;
    public Material material;

    public void onEnable(){}
    public void skillEffect(){}
    public void onClick() throws InterruptedException {}
    public void onClick(Player p){}
    public void onClick(Player m,Player p){}
    public void onClick(LivingEntity t){}
    public void onSwing() {
        if (this.coolTime == 0) {
            this.coolTime = this.time;
        }
    }
    public void sendActionBar(Player p) {
        p.sendActionBar(this.coolTime+ "초 남음");
    }

    public void minTime(){
        if (this.coolTime>0) {
            --this.coolTime;
        }
        //if (this.time>0) {
        //    --this.time;
        //}
    }

}
