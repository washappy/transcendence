package behappy.hap.stats.command;

import behappy.hap.GUI.StatsUI;
import behappy.hap.mangers.FileManager;
import behappy.hap.stats.human.Human;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static behappy.hap.mangers.ArrayManager.playerData;
import static behappy.hap.mangers.FileManager.jsonFile;

public class Stats implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if (sender instanceof Player) {
            Player player = (Player) sender;

            String playername = player.getPlayer().getName();

            if ("info".equals(args[0])) {
                player.sendMessage((playerData.get(player.getPlayer().getName())).info());
            }
            else if("save".equals(args[0])) {
                saveFile(player);
            }
            else if("help".equals(args[0])) {
                statsHelp(player);
            }
            else if("open".equals(args[0])) {
                new StatsUI(player);
            }
            else if ("add".equals(args[0]) && Integer.valueOf(args[2]) instanceof Integer) {
                int num = Integer.valueOf(args[2]);
                switch (args[1]) {
                    case "strength":
                        player.sendMessage(args[1] + " is added " + args[2]);
                        playerData.get(playername).addStrength(num);
                        break;
                    case "agility" :
                        player.sendMessage(args[1] +" is added " + args[2]);
                        playerData.get(playername).addAgility(num);
                        break;
                    case "speed" :
                        player.sendMessage(args[1] +" is added " + args[2]);
                        playerData.get(playername).addSpeed(num);
                        break;
                    case "health" :
                        player.sendMessage(args[1] +" is added " + args[2]);
                        playerData.get(playername).addHealth(num);
                        break;
                    case "defense":
                        player.sendMessage(args[1] +" is added " + args[2]);
                        playerData.get(playername).addDefense(num);
                        break;
                    case "luck" :
                        player.sendMessage(args[1] +" is added " + args[2]);
                        playerData.get(playername).addLuck(num);
                        break;
                    case "handicraft" :
                        player.sendMessage(args[1] +" is added " + args[2]);
                        playerData.get(playername).addHandicraft(num);
                        break;
                    case "attractive" :
                        player.sendMessage(args[1] +" is added " + args[2]);
                        playerData.get(playername).addAttractive(num);
                        break;
                    default:
                        sender.sendMessage("????????? ?????????");
                        break;
                }
                jsonFile.put(playername,playerData.get(playername).getMap());
                Human.setAttributes(player,playerData.get(playername));
            }

            return true;
        }
        return false;
    }

    private void statsHelp(Player player) {
        player.sendMessage("\n================");
        player.sendMessage("/stats info : ?????? ?????? ??????");
        player.sendMessage("/stats add <????????????> <???> : ?????? ?????????");
        player.sendMessage("/stats save : ?????? ?????? ??????");
        player.sendMessage("/stats help : ?????? ?????? ??????");
        player.sendMessage("/stats open : ?????? ??? ??????");
        player.sendMessage("================");
    }

    private void saveFile(Player player) {
        FileManager.saveAll();
        player.sendMessage("stats saved");
    }
}
