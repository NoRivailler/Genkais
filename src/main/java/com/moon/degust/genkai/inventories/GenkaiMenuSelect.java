package com.moon.degust.genkai.inventories;

import com.moon.degust.genkai.Genkai;
import com.moon.degust.genkai.builder.items.ItemBuilder;
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

@SuppressWarnings("SpellCheckingInspection")
public class GenkaiMenuSelect implements Listener {

    private static final Genkai PLUGIN = Genkai.getInstance();

    public void open(Player p) {

        // INVENTORY
        Inventory inv = Bukkit.createInventory(null, 4 * 9, "Kekkei Genkai");

        ItemStack mokutonItem = new ItemBuilder(Material.LOG)
                .setDisplayName("§aMokuton")
                .setLore(Arrays.asList(
                        "§7- §fÉ uma alteração de natureza",
                        " §fque combina terra e água para criar madeira."
                ))
                .build();
        inv.setItem(11, mokutonItem);



        ItemStack bakutonItem = new ItemBuilder(Material.LOG)
                .setDisplayName("§aBakuton")
                .setLore(Arrays.asList(
                        "§7- §fEsta natureza da ao seu portador",
                        " §fa capacidade de utilizar o chakra explosivo em combate."
                ))
                .build();
        inv.setItem(21, bakutonItem);



        ItemStack shotonItem = new ItemBuilder(Material.LOG)
                .setDisplayName("§aShoton")
                .setLore(Arrays.asList(
                        "§7- §fÉ um tipo de alteração de natureza",
                        " §fque permite ao usuário criar cristal",
                        " §fou manipular cristais já existentes."
                ))
                .build();
        inv.setItem(13, shotonItem);


        ItemStack hyotonItem = new ItemBuilder(Material.LOG)
                .setDisplayName("§aHyoton")
                .setLore(Arrays.asList(
                        "§7- §fHyoton da ao seu portador a",
                        " §fhabilidade de manipular o gelo",
                        " §fou manipular cristais já existentes."
                ))
                .build();
        inv.setItem(23, hyotonItem);



        ItemStack rantomItem = new ItemBuilder(Material.LOG)
                .setDisplayName("§aRanton")
                .setLore(Arrays.asList(
                        "§7- §fÉ uma avançada natureza que cria feixes de energia",
                        " §fque podem ser guiados em direção ao inimigo."
                ))
                .build();
        inv.setItem(15, rantomItem);


        ItemStack warningItem = new ItemBuilder(Material.LOG)
                .setDisplayName("§c§lAVISO!")
                .setLore(Arrays.asList(
                        "§7? §fVocê pode §lunicamente §fe §lapenas ",
                        " §fescolher uma kekkei genkai."
                ))
                .build();
        inv.setItem(27, warningItem);


        p.openInventory(inv);

    }

    @EventHandler
    public void onPlayerClickInventory(final InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();

        if (!e.getInventory().getTitle().equalsIgnoreCase("Kekkei Genkai")) return;


        if (e.getInventory().getTitle().equalsIgnoreCase("Kekkei Genkai") && item != null
                && item.getTypeId() != 0) {
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
