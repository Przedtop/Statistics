package com.przedtop.statistics;

import com.przedtop.statistics.dbOperations.EditDBStats;
import com.przedtop.statistics.dbOperations.GetDBStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Deaths implements Listener {

    @EventHandler
    void onDeath(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        EditDBStats editDBStats = new EditDBStats();
        editDBStats.incrementDeaths(player);
        GetDBStats getDBStats = new GetDBStats();
        player.sendMessage("You have died " + getDBStats.getDeaths(player) + " times.");
    }
}
