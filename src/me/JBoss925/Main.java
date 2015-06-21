package me.JBoss925;

import me.JBoss925.ConfigExecutors.ConfigInterpreter;
import me.JBoss925.ConfigExecutors.ConfigWriter;
import me.JBoss925.QuestMechanics.QuestManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by jagger1 on 6/20/15.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
        new ConfigWriter(this).writeDefaults();
        new QuestManager(this).setQuests(new ConfigInterpreter(this).getQuests());
    }

    @Override
    public void onDisable(){
        this.saveConfig();
    }
}
