package com.przedtop.statistics;

import com.przedtop.statistics.dbOperations.EditDBStats;
import com.przedtop.statistics.dbOperations.GetDBStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlock implements Listener {

    @EventHandler
    void onPlaceBlock(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        EditDBStats editDBStats = new EditDBStats();
        editDBStats.incrementBlocksPlaced(player);
        GetDBStats getDBStats = new GetDBStats();
        player.sendMessage("You have placed " + getDBStats.getBlocksPlaced(player) + " blocks.");
    }
}
