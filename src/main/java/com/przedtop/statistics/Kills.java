package com.przedtop.statistics;

import com.przedtop.statistics.dbOperations.EditDBStats;
import com.przedtop.statistics.dbOperations.GetDBStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Kills implements Listener {

    @EventHandler
    void onKill(PlayerDeathEvent e) {
        Player player = e.getEntity().getKiller();
        if (player == null) {
            return;
        }
        EditDBStats editDBStats = new EditDBStats();
        editDBStats.incrementKills(player);
        GetDBStats getDBStats = new GetDBStats();
        player.sendMessage("You have killed " + getDBStats.getKills(player) + " players.");
    }
}
