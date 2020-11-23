package com.moon.degust.genkai;

import com.moon.degust.genkai.inventories.GenkaiMenuSelect;
import com.moon.degust.genkai.manager.ElementManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Genkai extends JavaPlugin {

    private static Genkai instance;

    @Getter
    private ElementManager elementManager;

    public void onEnable() {
        instance = this;

        elementManager = new ElementManager();

        loadConfiguration();

        registerEvents();
        registerCommands();
    }

    public void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new GenkaiMenuSelect(), this);
    }

    public void registerCommands() {
        getCommand("genkai").setExecutor(new Genkai());
    }

    public void loadConfiguration() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Genkai getInstance() {
        return instance;
    }


}
