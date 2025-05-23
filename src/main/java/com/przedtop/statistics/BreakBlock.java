package com.przedtop.statistics;

import com.przedtop.statistics.dbOperations.EditDBStats;
import com.przedtop.statistics.dbOperations.GetDBStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlock implements Listener {
    @EventHandler
    void onBreakBlock(BlockBreakEvent e) {
        Player player = e.getPlayer();
        EditDBStats editDBStats = new EditDBStats();
        editDBStats.incrementBlocksBroken(player);
        GetDBStats getDBStats = new GetDBStats();
        e.getPlayer().sendMessage("You have broken " + getDBStats.getBlocksBroken(player) + " blocks.");
    }
}
