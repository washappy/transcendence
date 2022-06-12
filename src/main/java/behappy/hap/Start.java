package behappy.hap;

import behappy.hap.character.character.invincible.Invincible;
import behappy.hap.character.character.minato.Minato;
import behappy.hap.character.character.wwd.WWD;
import behappy.hap.character.command.Ability;
import behappy.hap.character.command.TabCompletion;
import behappy.hap.listeners.*;
import behappy.hap.mangers.ArrayManager;
import behappy.hap.mangers.FileManager;
import behappy.hap.stats.command.AllTimePlayer;
import behappy.hap.stats.command.AutoTab;
import behappy.hap.stats.command.Stats;
import behappy.hap.stats.human.Human;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

import static behappy.hap.character.base.CharacterBase.pAbility;
import static behappy.hap.mangers.ArrayManager.humanss;
import static behappy.hap.mangers.ArrayManager.playerData;
import static behappy.hap.mangers.FileManager.jsonFile;
import static behappy.hap.mangers.FileManager.jsonList;

public final class Start extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "능력자 플러그인 Enabled");
        getCommands();
        registerEvents();
        //FileManager.saveAll();
        //ArrayManager.putJson();
        myScheduler();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "능력자 플러그인 Disabled");
        //FileManager.saveAll();
    }

    private void getCommands() {
        Objects.requireNonNull(getCommand("stats")).setExecutor(new Stats());
        Objects.requireNonNull(getCommand("stats")).setTabCompleter(new AutoTab());
        Objects.requireNonNull(getCommand("alltime")).setExecutor(new AllTimePlayer());
        Objects.requireNonNull(getCommand("ability")).setExecutor(new Ability());
        Objects.requireNonNull(getCommand("ability")).setTabCompleter(new TabCompletion());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new LevelListener(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new LeftClickListener(), this);
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new HitListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
    }

    private void myScheduler(){
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()){
                    if (pAbility.get(all.getName())!=null) {
                        pAbility.get(all.getName()).skillA.minTime();
                        pAbility.get(all.getName()).skillB.minTime();
                        pAbility.get(all.getName()).skillC.minTime();
                        showActionBar(all);
                    }

                    String playerName;
                    playerName = all.getName();
                    boolean contains = humanss.contains(playerName);
                    if (contains) {
                        //if (FileManager.getFile()==null||FileManager.getFile().get(playerName)==null) {
                            Human hum = new Human(playerName);
                            playerData.put(playerName,hum);
                            Bukkit.getLogger().info(playerName+"으로 인스턴트 생성");

                            jsonFile.put(playerName,hum.getMap());
                        /*} else {
                            if (playerData.get(playerName)==null) {
                                Human hum = (Human) FileManager.getFile().get(playerName);
                                playerData.put(playerName,hum);
                            }
                        }*/

                        Human.setAttributes(all,playerData.get(playerName));
                    } else {
                        Human hum = new Human(playerName);
                        humanss.add(playerName);
                        playerData.put(playerName,hum);
                        Bukkit.getLogger().info(playerName+"으로 인스턴트 생성");

                        jsonList.add(playerName);
                        jsonFile.put(playerName,hum.getMap());
                        Human.setAttributes(all,playerData.get(playerName));
                    }
                }
            }
        },20*0,20*1);
    }

    private void showActionBar(Player all){
        if (pAbility.get(all.getName()) instanceof WWD) {
            wwdShow(all);
        } else if (pAbility.get((all.getName())) instanceof Minato) {
            minatoShow(all);
        } else if (pAbility.get(all.getName()) instanceof Invincible) {
            invincibleShow(all);
        }
    }

    private void wwdShow(Player player) {
        if (player.getItemInHand().getType()== Material.STICK) {
            pAbility.get(player.getName()).skillA.sendActionBar(player);
        } else if(player.getItemInHand().getType()== Material.FIRE_CHARGE) {
            pAbility.get(player.getName()).skillB.sendActionBar(player);
        }
    }
    private void minatoShow(Player p) {
        if (p.getItemInHand().getType()==Material.WOODEN_SWORD||p.getItemInHand().getType()==Material.STONE_SWORD||p.getItemInHand().getType()==Material.IRON_SWORD||p.getItemInHand().getType()==Material.GOLDEN_SWORD||p.getItemInHand().getType()==Material.DIAMOND_SWORD||p.getItemInHand().getType()==Material.NETHERITE_SWORD) {
            pAbility.get(p.getName()).skillB.sendActionBar(p);
        } else if (p.getItemInHand().getType()==Material.ARROW) {
            pAbility.get(p.getName()).skillA.sendActionBar(p);
        }
    }
    private void invincibleShow(Player p) {
        if (p.getItemInHand().getType()==Material.STICK) {
            pAbility.get(p.getName()).skillA.sendActionBar(p);
        } else if (p.getItemInHand().getType()==Material.BLAZE_ROD) {
            pAbility.get(p.getName()).skillB.sendActionBar(p);
        }
    }
}