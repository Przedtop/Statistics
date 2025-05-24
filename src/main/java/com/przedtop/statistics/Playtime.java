package com.przedtop.statistics;

import com.przedtop.statistics.dbOperations.EditDBStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Playtime {

    private final JavaPlugin plugin;
    private final int playtimeIncrease = 10; // seconds

    public Playtime(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void startPlaytimeTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    new EditDBStats().incresePlayTime(player, playtimeIncrease);
                    Bukkit.getConsoleSender().sendMessage("Updating playtime for: " + player.getName());
                }
            }
        }.runTaskTimer(plugin, 0L, playtimeIncrease * 20L);
    }
}
