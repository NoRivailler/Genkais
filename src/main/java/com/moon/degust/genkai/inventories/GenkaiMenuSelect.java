package com.moon.degust.genkai.inventories;

import com.moon.degust.genkai.Genkai;
import com.moon.degust.genkai.builder.items.ItemBuilder;
import com.moon.degust.genkai.objects.Element;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("SpellCheckingInspection")
public class GenkaiMenuSelect implements Listener {

    private static final Genkai PLUGIN = Genkai.getInstance();

    public void open(Player p) {
        Inventory inv = Bukkit.createInventory(null, 4 * 9, "Kekkei Genkai");

        Collection<Element> elements = PLUGIN.getElementManager().getElements();

        for (Element element : elements) {
            inv.setItem(element.getSlotBase(), element.getItem());
        }

        p.openInventory(inv);
    }

    @EventHandler
    public void onPlayerClickInventory(final InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();

        if (!e.getInventory().getTitle().equalsIgnoreCase("Kekkei Genkai")) return;
        if (item == null) return;

        e.setCancelled(true);

        if (item.getItemMeta().getDisplayName().equals("§aMokuton")) {
            p.closeInventory();
            p.sendMessage(" ");
            p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
            p.sendMessage("§7§lMokuton §fdefinido com sucesso!");
            p.sendMessage(" ");
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 4.0F, 4.0F);
            p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

            ConfigurationSection cfg = PLUGIN.getConfig().getConfigurationSection("Mokuton");

            for (String item : cfg.getKeys(false)) {

                ItemStack a1 = new ItemStack(cfg.getInt(item + ".item01" + ".id"), 1, (short) 0);
                ItemMeta a1m = a1.getItemMeta();
                a1m.setDisplayName(cfg.getString(item + ".item01" + ".nome").replace("&", "§"));
                a1.setItemMeta(a1m);
                p.getInventory().addItem(a1);

                ItemStack a2 = new ItemStack(cfg.getInt(item + "item02.id"), 1, (short) 0);
                ItemMeta a2m = a2.getItemMeta();
                a2m.setDisplayName(cfg.getString(item + "item02.nome").replace("&", "§"));
                a2.setItemMeta(a2m);
                p.getInventory().addItem(a2);


                ItemStack a3 = new ItemStack(cfg.getInt(item + "item03.id"), 1, (short) 0);
                ItemMeta a3m = a3.getItemMeta();
                a3m.setDisplayName(cfg.getString(item + "item03.nome").replace("&", "§"));
                a3.setItemMeta(a3m);
                p.getInventory().addItem(a3);
            }
            return;
        }

        if (item.getItemMeta().getDisplayName().equals("§aBakuton")) {
            p.closeInventory();
            p.sendMessage(" ");
            p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
            p.sendMessage("§7§lBakuton §fdefinido com sucesso!");
            p.sendMessage(" ");
            p.playSound(p.getLocation(), Sound.EXPLODE, 4.0F, 4.0F);
            p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

            ConfigurationSection cfg = PLUGIN.getConfig().getConfigurationSection("Bakuton");

            for (String item : cfg.getKeys(false)) {

                ItemStack a1 = new ItemStack(cfg.getInt(item + "item01.id"), 1, (short) 0);
                ItemMeta a1m = a1.getItemMeta();
                a1m.setDisplayName(cfg.getString(item + "item01.nome").replace("&", "§"));
                a1.setItemMeta(a1m);
                p.getInventory().addItem(a1);

                ItemStack a2 = new ItemStack(cfg.getInt(item + "item02.id"), 1, (short) 0);
                ItemMeta a2m = a2.getItemMeta();
                a2m.setDisplayName(cfg.getString(item + "item02.nome").replace("&", "§"));
                a2.setItemMeta(a2m);
                p.getInventory().addItem(a2);


                ItemStack a3 = new ItemStack(cfg.getInt(item + "item03.id"), 1, (short) 0);
                ItemMeta a3m = a3.getItemMeta();
                a3m.setDisplayName(cfg.getString(item + "item03.nome").replace("&", "§"));
                a3.setItemMeta(a3m);
                p.getInventory().addItem(a3);
            }
            return;
        }

        if (item.getItemMeta().getDisplayName().equals("§aShoton")) {
            p.closeInventory();
            p.sendMessage(" ");
            p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
            p.sendMessage("§7§lShoton §fdefinido com sucesso!");
            p.sendMessage(" ");
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);
            p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

            ConfigurationSection cfg = PLUGIN.getConfig().getConfigurationSection("Shoton");

            for (String item : cfg.getKeys(false)) {

                ItemStack a1 = new ItemStack(cfg.getInt(item + "item01.id"), 1, (short) 0);
                ItemMeta a1m = a1.getItemMeta();
                a1m.setDisplayName(cfg.getString(item + "item01.nome").replace("&", "§"));
                a1.setItemMeta(a1m);
                p.getInventory().addItem(a1);

                ItemStack a2 = new ItemStack(cfg.getInt(item + "item02.id"), 1, (short) 0);
                ItemMeta a2m = a2.getItemMeta();
                a2m.setDisplayName(cfg.getString(item + "item02.nome").replace("&", "§"));
                a2.setItemMeta(a2m);
                p.getInventory().addItem(a2);


                ItemStack a3 = new ItemStack(cfg.getInt(item + "item03.id"), 1, (short) 0);
                ItemMeta a3m = a3.getItemMeta();
                a3m.setDisplayName(cfg.getString(item + "item03.nome").replace("&", "§"));
                a3.setItemMeta(a3m);
                p.getInventory().addItem(a3);
            }
            return;
        }

        if (item.getItemMeta().getDisplayName().equals("§aHyoton")) {
            p.closeInventory();
            p.sendMessage(" ");
            p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
            p.sendMessage("§7§lHyoton §fdefinido com sucesso!");
            p.sendMessage(" ");
            p.playSound(p.getLocation(), Sound.GLASS, 4.0F, 4.0F);
            p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

            ConfigurationSection cfg = PLUGIN.getConfig().getConfigurationSection("Hyoton");

            for (String item : cfg.getKeys(false)) {

                ItemStack a1 = new ItemStack(cfg.getInt(item + "item01.id"), 1, (short) 0);
                ItemMeta a1m = a1.getItemMeta();
                a1m.setDisplayName(cfg.getString(item + "item01.nome").replace("&", "§"));
                a1.setItemMeta(a1m);
                p.getInventory().addItem(a1);

                ItemStack a2 = new ItemStack(cfg.getInt(item + "item02.id"), 1, (short) 0);
                ItemMeta a2m = a2.getItemMeta();
                a2m.setDisplayName(cfg.getString(item + "item02.nome").replace("&", "§"));
                a2.setItemMeta(a2m);
                p.getInventory().addItem(a2);


                ItemStack a3 = new ItemStack(cfg.getInt(item + "item03.id"), 1, (short) 0);
                ItemMeta a3m = a3.getItemMeta();
                a3m.setDisplayName(cfg.getString(item + "item03.nome").replace("&", "§"));
                a3.setItemMeta(a3m);
                p.getInventory().addItem(a3);
            }
            return;
        }

        if (item.getItemMeta().getDisplayName().equals("§aRanton")) {
            p.closeInventory();
            p.sendMessage(" ");
            p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
            p.sendMessage("§7§lRanton §fdefinido com sucesso!");
            p.sendMessage(" ");
            p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 4.0F, 4.0F);
            p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

            ConfigurationSection cfg = PLUGIN.getConfig().getConfigurationSection("Ranton");

            for (String item : cfg.getKeys(false)) {

                ItemStack a1 = new ItemStack(cfg.getInt(item + "item01.id"), 1, (short) 0);
                ItemMeta a1m = a1.getItemMeta();
                a1m.setDisplayName(cfg.getString(item + "item01.nome").replace("&", "§"));
                a1.setItemMeta(a1m);
                p.getInventory().addItem(a1);

                ItemStack a2 = new ItemStack(cfg.getInt(item + "item02.id"), 1, (short) 0);
                ItemMeta a2m = a2.getItemMeta();
                a2m.setDisplayName(cfg.getString(item + "item02.nome").replace("&", "§"));
                a2.setItemMeta(a2m);
                p.getInventory().addItem(a2);


                ItemStack a3 = new ItemStack(cfg.getInt(item + "item03.id"), 1, (short) 0);
                ItemMeta a3m = a3.getItemMeta();
                a3m.setDisplayName(cfg.getString(item + "item03.nome").replace("&", "§"));
                a3.setItemMeta(a3m);
                p.getInventory().addItem(a3);
            }
            return;
        }

    }
}

}
