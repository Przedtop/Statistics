package com.przedtop.statistics;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BreakBlock(),this);
        getServer().getPluginManager().registerEvents(new OnJoin(),this);
        getServer().getPluginManager().registerEvents(new PlaceBlock(),this);
        getServer().getPluginManager().registerEvents(new Deaths(),this);
        getServer().getPluginManager().registerEvents(new Kills(),this);

        new Playtime(this).startPlaytimeTask();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
