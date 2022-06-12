package behappy.hap.GUI;

import behappy.hap.character.base.CharacterBase;
import behappy.hap.stats.human.Human;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static behappy.hap.character.base.CharacterBase.pAbility;
import static behappy.hap.mangers.ArrayManager.playerData;
import static behappy.hap.mangers.ArrayManager.playerLocate;

public class CharacterUI extends GuiBase{
    private static final HashMap<Player, Integer> onPage = new HashMap<>();

    public CharacterUI(@NotNull Player p) {
        super(p, 9, "info");
    }

    @Override
    protected void init(Player p) {

        onPage.putIfAbsent(p, 0);

        CharacterBase character = pAbility.get(p.getName());

        setItem(character.name, Collections.singletonList(character.description), Material.APPLE, 1, 2, "", true);

        setItem(character.skillA.name, Collections.singletonList(character.skillA.description), character.skillA.material, 1, 4, "skill.a", true);
        setItem(character.skillB.name, Collections.singletonList(character.skillB.description), character.skillB.material, 1, 5, "skill.b", true);
        setItem(character.skillC.name, Collections.singletonList(character.skillC.description), character.skillC.material, 1, 6, "skill.c", true);

        setItem("현재 페이지/새로고침", Arrays.asList("현재 페이지를 나타냅니다.", "눌러서 새로고침"),  Material.BEACON, 1, 0, "skill.reload", false);
        setItem("현재 페이지/닫기",Collections.singletonList("페이지 닫기"),  Material.BARRIER, 1, 8, "skill.close", false);
    }

    @Override
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        String playerName = p.getPlayer().getName();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        CharacterBase character = pAbility.get(p.getName());

        if(btn==null) return;

        switch (btn){
            case "skill.a":
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                p.getInventory().addItem(new ItemStack(character.skillA.material));
                break;
            case "skill.b":
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                p.getInventory().addItem(new ItemStack(character.skillB.material));
                break;
            case "skill.c":
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                p.getInventory().addItem(new ItemStack(character.skillC.material));
                break;
            case "skill.reload":
                new CharacterUI(p);
                break;
            case "skill.close":
                this.forceCloseGUI(p);
                break;
            default:
                break;
        }
    }
}
