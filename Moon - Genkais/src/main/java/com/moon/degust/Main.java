package com.moon.degust;

import com.moon.degust.comandos.Genkai;
import com.moon.degust.menus.GenkaiMenuSelect;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable() {

        instance = this;

        loadConfiguration();

        Eventos();
        Comandos();

        ConsoleCommandSender cs = Bukkit.getConsoleSender();
        cs.sendMessage("§aPlugin iniciado com sucesso.");
        cs.sendMessage("§fCreated by Degust");
    }

    public void Eventos() {
        Bukkit.getServer().getPluginManager().registerEvents(new GenkaiMenuSelect(), this);
    }

    public void Comandos() {
        getCommand("genkai").setExecutor(new Genkai());
    }

    public void loadConfiguration() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}
