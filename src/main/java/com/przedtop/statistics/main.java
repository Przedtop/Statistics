package com.przedtop.statistics;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BreakBlock(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
