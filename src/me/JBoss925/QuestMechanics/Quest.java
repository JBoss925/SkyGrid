package me.JBoss925.QuestMechanics;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


/**
 * Created by jagger1 on 6/21/15.
 */
public class Quest {

    Material itemMaterial;
    Boolean givesKey;
    ItemStack key;
    String questName;
    String lore;
    HashMap<Material, Integer> requirements;
    HashMap<Material, Integer> reward;

    public Quest(Material itemMaterial,
                 String questName,
                 String lore,
                 HashMap<Material, Integer> requirements,
                 HashMap<Material, Integer> reward, Boolean givesKey, ItemStack key){
        this.itemMaterial = itemMaterial;
        this.questName = questName;
        this.lore = lore;
        this.requirements = requirements;
        this.reward = reward;
        this.givesKey = givesKey;
        this.key = key;
    }

    public String getName(){
        return this.questName;
    }

}
