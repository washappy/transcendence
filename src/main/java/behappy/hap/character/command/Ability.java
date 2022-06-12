package behappy.hap.character.command;

import behappy.hap.character.base.CharacterBase;
import behappy.hap.character.character.invincible.Invincible;
import behappy.hap.character.character.minato.Minato;
import behappy.hap.character.character.wwd.WWD;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static behappy.hap.character.base.CharacterBase.pAbility;

public class Ability implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if (sender instanceof Player) {

            Player player = (Player) sender;
            if (args.length == 1) {
                if (whatAbility(player,args[0])!=null) {
                    pAbility.put(player.getName(),whatAbility(player,args[0]));
                    sender.sendMessage(args[0] + "(으)로 능력이 추가되었습니다.");
                    Bukkit.getLogger().info(args[0] + "(으)로 능력이 추가되었습니다.");
                }
            }
            else {
                sender.sendMessage(cmd.getUsage());
            }

            return true;
        }
        return false;
    }

    private CharacterBase whatAbility(Player p, String s){
        if (s.equals("wwd")){
            return new WWD(p);
        } else if(s.equals("invincible")) {
            return new Invincible(p);
        } else if(s.equals("minato")) {
            return new Minato(p);
        }
        return null;
    }
}
