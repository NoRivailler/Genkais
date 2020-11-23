package com.moon.degust.menus;

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

import static com.moon.degust.Main.*;

import java.util.ArrayList;

public class GenkaiMenuSelect implements Listener {

    public static void open(Player p) {

        // INVENTORY
        Inventory inv = Bukkit.createInventory(null, 4 * 9, "Kekkei Genkai");

            final ItemStack mokuton = new ItemStack(Material.LOG, 1);
            final ItemMeta mokutonm = mokuton.getItemMeta();
            mokutonm.setDisplayName("§aMokuton");
            ArrayList<String> lore1 = new ArrayList<String>();
            lore1.add("§7- §fÉ uma alteração de natureza");
            lore1.add(" §fque combina terra e água para criar madeira.");
            mokutonm.setLore(lore1);
            mokuton.setItemMeta(mokutonm);
            inv.setItem(11, mokuton);

            final ItemStack bakuton = new ItemStack(Material.MAGMA_CREAM, 1);
            final ItemMeta bakutonm = bakuton.getItemMeta();
            bakutonm.setDisplayName("§aBakuton");
            ArrayList<String> lore2 = new ArrayList<String>();
            lore2.add("§7- §fEsta natureza da ao seu portador");
            lore2.add(" §fa capacidade de utilizar o chakra explosivo em combate.");
            bakutonm.setLore(lore2);
            bakuton.setItemMeta(bakutonm);
            inv.setItem(21, bakuton);

            final ItemStack shoton = new ItemStack(Material.NETHER_STAR, 1);
            final ItemMeta shotonm = shoton.getItemMeta();
            shotonm.setDisplayName("§aShoton");
            ArrayList<String> lore3 = new ArrayList<String>();
            lore3.add("§7- §fÉ um tipo de alteração de natureza");
            lore3.add(" §fque permite ao usuário criar cristal");
            lore3.add(" §fou manipular cristais já existentes.");
            shotonm.setLore(lore3);
            shoton.setItemMeta(shotonm);
            inv.setItem(13, shoton);

            final ItemStack hyoton = new ItemStack(Material.PACKED_ICE, 1);
            final ItemMeta hyotonm = hyoton.getItemMeta();
            hyotonm.setDisplayName("§aHyoton");
            ArrayList<String> lore4 = new ArrayList<String>();
            lore4.add("§7- §fHyoton da ao seu portador a");
            lore4.add(" §fhabilidade de manipular o gelo");
            hyotonm.setLore(lore4);
            hyoton.setItemMeta(hyotonm);
            inv.setItem(23, hyoton);

            final ItemStack ranton = new ItemStack(Material.EYE_OF_ENDER, 1);
            final ItemMeta rantonm = ranton.getItemMeta();
            rantonm.setDisplayName("§aRanton");
            ArrayList<String> lore5 = new ArrayList<String>();
            lore5.add("§7- §fÉ uma avançada natureza que cria feixes de energia");
            lore5.add(" §fque podem ser guiados em direção ao inimigo.");
            rantonm.setLore(lore5);
            ranton.setItemMeta(rantonm);
            inv.setItem(15, ranton);

            final ItemStack aviso = new ItemStack(Material.SIGN, 1);
            final ItemMeta avisom = ranton.getItemMeta();
            avisom.setDisplayName("§c§lAVISO!");
            ArrayList<String> lore6 = new ArrayList<String>();
            lore6.add("§7? §fVocê pode §lunicamente §fe §lapenas ");
            lore6.add(" §fescolher uma kekkei genkai.");
            avisom.setLore(lore6);
            aviso.setItemMeta(avisom);
            inv.setItem(27, aviso);

        p.openInventory(inv);

    }

    @EventHandler
    public void onPlayerClickInventory(final InventoryClickEvent e) {

        final Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equalsIgnoreCase("Kekkei Genkai") && e.getCurrentItem() != null
                && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aMokuton")) {
                p.closeInventory();
                p.sendMessage(" ");
                p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
                p.sendMessage("§7§lMokuton §fdefinido com sucesso!");
                p.sendMessage(" ");
                p.playSound(p.getLocation(), Sound.CHEST_OPEN, 4.0F, 4.0F);
                p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

                ConfigurationSection cfg = getInstance().getConfig().getConfigurationSection("Mokuton");

                for(String item : cfg.getKeys(false)) {

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

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aBakuton")) {
                p.closeInventory();
                p.sendMessage(" ");
                p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
                p.sendMessage("§7§lBakuton §fdefinido com sucesso!");
                p.sendMessage(" ");
                p.playSound(p.getLocation(), Sound.EXPLODE, 4.0F, 4.0F);
                p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

                ConfigurationSection cfg = getInstance().getConfig().getConfigurationSection("Bakuton");

                for(String item : cfg.getKeys(false)) {

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

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aShoton")) {
                p.closeInventory();
                p.sendMessage(" ");
                p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
                p.sendMessage("§7§lShoton §fdefinido com sucesso!");
                p.sendMessage(" ");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);
                p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

                ConfigurationSection cfg = getInstance().getConfig().getConfigurationSection("Shoton");

                for(String item : cfg.getKeys(false)) {

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

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aHyoton")) {
                p.closeInventory();
                p.sendMessage(" ");
                p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
                p.sendMessage("§7§lHyoton §fdefinido com sucesso!");
                p.sendMessage(" ");
                p.playSound(p.getLocation(), Sound.GLASS, 4.0F, 4.0F);
                p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

                ConfigurationSection cfg = getInstance().getConfig().getConfigurationSection("Hyoton");

                for(String item : cfg.getKeys(false)) {

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

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aRanton")) {
                p.closeInventory();
                p.sendMessage(" ");
                p.sendMessage("§aParabéns! Você selecionou sua §lKekkei Genkai§a.");
                p.sendMessage("§7§lRanton §fdefinido com sucesso!");
                p.sendMessage(" ");
                p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 4.0F, 4.0F);
                p.getServer().dispatchCommand(p.getServer().getConsoleSender(), "manuaddp " + p.getName() + " genkai.select");

                ConfigurationSection cfg = getInstance().getConfig().getConfigurationSection("Ranton");

                for(String item : cfg.getKeys(false)) {

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
