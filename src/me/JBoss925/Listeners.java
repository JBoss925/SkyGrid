package me.JBoss925;

import me.JBoss925.InventoryMechanics.IconMenuManager;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by jagger1 on 6/20/15.
 */
public class Listeners implements Listener {

    Main plugin;

    public Listeners(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN){
                Sign s = (Sign) e.getClickedBlock().getState();
                if(s.getLine(0).equalsIgnoreCase("quests")){
                    new IconMenuManager(this.plugin).getQuestIconMenu(0).open(e.getPlayer());
                }
            }
        }
    }

}
