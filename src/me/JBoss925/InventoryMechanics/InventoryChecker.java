package me.JBoss925.InventoryMechanics;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jagger1 on 6/21/15.
 */
public class InventoryChecker {

    public InventoryChecker(){

    }

    public static boolean hasEnoughOfEach(HashMap<Material, Integer> requirements, Player p){
        for(Material m: requirements.keySet()){
            if(!p.getInventory().contains(m)){
                return false;
            }
            ItemStack[] items = p.getInventory().getContents();
            ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>(Arrays.asList(items));
            for(ItemStack i: items){
                if(i.getType() == m || i.getAmount() >= requirements.get(m)){
                    break;
                }
                if(itemStacks.indexOf(i) >= p.getInventory().getSize()-1){
                    return false;
                }
            }
        }
        return true;
    }





}
