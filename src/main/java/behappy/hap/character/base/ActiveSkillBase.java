package behappy.hap.character.base;

public abstract class ActiveSkillBase extends SkillBase {
    @Override
    public void onClick(){
        if (coolTime==0) {
            this.onEnable();
            this.skillEffect();
            this.coolTime = this.time;
        } else {
            player.sendActionBar("쿨타임 중 " + this.coolTime +"초 남음");
        }
    }
}
