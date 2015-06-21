package me.JBoss925.InventoryMechanics;

import me.JBoss925.ConfigExecutors.ConfigInterpreter;
import me.JBoss925.Main;
import me.JBoss925.QuestMechanics.Quest;
import me.JBoss925.QuestMechanics.QuestManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jagger1 on 6/21/15.
 */
public class IconMenuManager {

    List<IconMenu> menus = new ArrayList<IconMenu>();
    Main plugin;
    String nullQuest = ChatColor.BOLD + "" + ChatColor.RED + "You have selected a quest that has not been programmed yet.";
    String notEnoughItems = ChatColor.BOLD + "" + ChatColor.RED + "You do not have enough items to complete this quest!";
    String notEnoughtInventorySpace = ChatColor.BOLD + "" + ChatColor.RED + "You do not have enough inventory space for this!";

    public IconMenuManager(Main plugin){
        this.plugin = plugin;
    }

    public IconMenuManager(IconMenu menu, Main plugin){
        this.menus.add(menu);
        this.plugin = plugin;
    }

    public IconMenuManager(List<IconMenu> menus, Main plugin){
        this.menus = menus;
        this.plugin = plugin;
    }

    public IconMenu getQuestIconMenu(Integer place){
        return menus.get(place);
    }

    public void createNewIconMenu(){
        IconMenu menu = new IconMenu("Quests", 36, new IconMenu.OptionClickEventHandler(){
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent e) {
                ConfigInterpreter c = new ConfigInterpreter(plugin);
                Quest quest = new Quest();
                for(Quest q : c.getQuests()){
                    if(q.getQuestName().equalsIgnoreCase(e.getName())){
                        quest = q;
                        break;
                    }
                }
                if(!c.getQuests().contains(quest)){
                    e.getPlayer().sendMessage(nullQuest);
                    return;
                }
                if(!InventoryChecker.hasEnoughOfEach(quest.getRequirements(), e.getPlayer())){
                    e.getPlayer().sendMessage(notEnoughItems);
                    return;
                }
                if(e.getPlayer().getInventory().firstEmpty() == -1 || e.getPlayer().getInventory().firstEmpty() >= e.getPlayer().getInventory().getSize()-quest.getReward().keySet().size()){
                    e.getPlayer().sendMessage(notEnoughtInventorySpace);
                    return;
                }
                ItemStack[] rewards = new ItemStack[] {};
                for(Material m : quest.getReward().keySet()){
                    ItemStack i = new ItemStack(m, quest.getReward().get(m));
                    rewards[rewards.length] = i;
                }
                e.getPlayer().getInventory().addItem(rewards);
                if(quest.getGivesKey()){
                    e.getPlayer().getInventory().addItem(quest.getKey());
                }
            }
        }, plugin);
        int x = 0;
        for(Quest q : new QuestManager(plugin).getQuests()){
            String[] lore = new String[q.getLore().size()];
            lore = q.getLore().toArray(lore);
            menu.setOption(x, new ItemStack(q.getItemMaterial(), 1), q.getQuestName(), lore);
        }
       this.menus.add(menu);
    }
}
