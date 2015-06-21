package me.JBoss925.QuestMechanics;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;


/**
 * Created by jagger1 on 6/21/15.
 */
public class Quest {

    Material itemMaterial;
    Boolean givesKey;
    ItemStack key;
    String questName;
    List<String> lore;
    HashMap<Material, Integer> requirements;
    HashMap<Material, Integer> reward;

    public Quest(Material itemMaterial,
                 String questName,
                 List<String> lore,
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

    public Quest(){}

    public String getName(){
        return this.questName;
    }

    public Material getItemMaterial(){ return this.itemMaterial; }

    public Boolean getGivesKey(){ return this.givesKey; }

    public ItemStack getKey() {
        return key;
    }

    public List<String> getLore() {
        return lore;
    }

    public HashMap<Material, Integer> getRequirements() {
        return requirements;
    }

    public HashMap<Material, Integer> getReward() {
        return reward;
    }

    public String getQuestName() {
        return questName;
    }

    public void setGivesKey(Boolean givesKey) {
        this.givesKey = givesKey;
    }

    public void setItemMaterial(Material itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    public void setKey(ItemStack key) {
        this.key = key;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public void setRequirements(HashMap<Material, Integer> requirements) {
        this.requirements = requirements;
    }

    public void setReward(HashMap<Material, Integer> reward) {
        this.reward = reward;
    }
}
