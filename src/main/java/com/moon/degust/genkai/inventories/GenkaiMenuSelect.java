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

        Collection<Element> elements = PLUGIN.getElementManager().getElements();

        for (Element element : elements) {


            if (item.getItemMeta().getDisplayName().equalsIgnoreCase(element.getName())) {

                p.closeInventory();
                p.sendMessage(" ");
                p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
                p.sendMessage("§7§lMokuton §fdefinido com sucesso!");
                p.sendMessage(" ");

                p.playSound(p.getLocation(), element.getCustomSoundOnChoose(), 4.0F, 4.0F);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), element.getCommand(p));


                for (ItemStack itemOnAdd : element.getItemsOnChoose()) {
                    p.getInventory().addItem(itemOnAdd);
                }

            }

        }

    }
}
