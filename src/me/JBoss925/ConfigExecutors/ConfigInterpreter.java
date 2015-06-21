package me.JBoss925.ConfigExecutors;


import me.JBoss925.Main;
import me.JBoss925.QuestMechanics.Quest;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by jagger1 on 6/20/15.
 */
public class ConfigInterpreter {

    Main plugin;
    FileConfiguration config = plugin.getConfig();

    public ConfigInterpreter(Main plugin){
        this.plugin = plugin;
    }

    public Quest getQuest(String questName){
        String basePath = "Quests." + questName + ".";
        HashMap<Material, Integer> requirements = new HashMap<Material, Integer>();
        for (String key : config.getConfigurationSection(basePath + "requirements").getKeys(false)) {
            requirements.put(Material.getMaterial(key), config.getInt(basePath + "requirements." + key));
        }
        HashMap<Material, Integer> reward = new HashMap<Material, Integer>();
        for (String key : config.getConfigurationSection(basePath + "reward").getKeys(false)) {
            requirements.put(Material.getMaterial(key), config.getInt(basePath + "reward." + key));
        }
        String lore = config.getString(basePath + "lore");
        Material material = Material.getMaterial(config.getString(basePath + "material"));
        if(config.getBoolean(basePath + "key")){
            String mat = config.getString(basePath + "key" + ".material");
            Material matt = Material.getMaterial(mat);
            ItemStack key = new ItemStack(matt, 1);
            key.addEnchantment(Enchantment.ARROW_FIRE, 1);
            key.getItemMeta().setDisplayName(config.getString(basePath + "key" + ".displayname"));
            key.getItemMeta().setLore(config.getStringList(basePath + "key" + ".lore"));
            return new Quest(material, questName, lore, requirements, reward, true, key);
        }
        else{
            return new Quest(material, questName, lore, requirements, reward, false, null);
        }
    }

    public List<Quest> getQuests(){
        Set<String> keys = plugin.getConfig().getConfigurationSection("Quests").getKeys(false);
        ArrayList<String> quests = new ArrayList<String>(keys);
        ArrayList<Quest> realQuests = new ArrayList<Quest>();
        for(String s: quests){
            realQuests.add(getQuest(s));
        }
        return realQuests;
    }

    public List<Quest> getQuestsCompletedBy(Player p){
        if(config.getStringList("Players." + p.getUniqueId()) == null){
            return new ArrayList<Quest>();
        }
        else{
            List<Quest> qs = new ArrayList<Quest>();
            for(String s: config.getStringList("Players." + p.getUniqueId())){
                qs.add(getQuest(s));
            }
            return qs;
        }
    }

}
