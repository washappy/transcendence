package behappy.hap.stats.command;

import behappy.hap.mangers.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static behappy.hap.mangers.ArrayManager.humanss;

public class AllTimePlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(String.valueOf(humanss));
            } else if (args.length == 1 && "clear".equals(args[0])) {
                humanss.clear();
                FileManager.jsonList.clear();
                player.sendMessage("all cleared");
            }
            else {
                sender.sendMessage("완전하지 않은 커멘드");
            }
            return true;
        }
        return false;
    }
}
