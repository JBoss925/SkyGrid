package me.JBoss925.ConfigExecutors;

import me.JBoss925.Main;
import me.JBoss925.QuestMechanics.Quest;
import org.bukkit.entity.Player;
import java.util.List;

/**
 * Created by jagger1 on 6/20/15
 */
public class ConfigWriter {

    Main plugin;

    public ConfigWriter(Main plugin){
        this.plugin = plugin;
    }

    public void writeDefaults(){
        plugin.saveDefaultConfig();
    }

    public void writePlayerQuest(Player p, Quest q){
        if(plugin.getConfig().contains("Players." + p.getUniqueId())){
            plugin.getConfig().createSection("Players." + p.getUniqueId());
        }
        List<String> questsCompleted = plugin.getConfig().getStringList("Players." + p.getUniqueId());
        questsCompleted.add(questsCompleted.size(), q.getName());
        plugin.getConfig().set("Players." + p.getUniqueId(), questsCompleted);
    }

}
