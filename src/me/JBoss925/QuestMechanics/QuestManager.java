package me.JBoss925.QuestMechanics;

import me.JBoss925.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jagger1 on 6/21/15.
 */
public class QuestManager {

    Main plugin;
    public List<Quest> quests = new ArrayList<Quest>();

    public QuestManager(Main plugin){
        this.plugin = plugin;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests){
        this.quests = quests;
    }
}
