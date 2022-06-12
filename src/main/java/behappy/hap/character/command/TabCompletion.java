package behappy.hap.character.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        Player player = (Player) sender;
        String playername = player.getPlayer().getName();

        if (args.length == 1) {
            List<String> arrayList = new ArrayList<>(5);

            arrayList.add("wwd");
            arrayList.add("invincible");
            arrayList.add("minato");

            return arrayList;
        }

        return null;
    }
}
