package com.moon.degust.comandos;

import com.moon.degust.menus.GenkaiMenuSelect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Genkai implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;

        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("genkai")) {
            if(p.hasPermission("genkai.select") && !p.isOp()) {
                p.sendMessage("§cVocê já escolheu sua genkai inicial!");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 4.0F, 4.0F);
                return false;
            }

            GenkaiMenuSelect.open(p);

        }

        return false;
    }
}
