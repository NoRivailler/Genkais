package com.moon.degust.genkai.manager;

import com.moon.degust.genkai.Genkai;
import com.moon.degust.genkai.builder.items.ItemBuilder;
import com.moon.degust.genkai.enums.Elements;
import com.moon.degust.genkai.objects.Element;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ElementManager {

    private static final Genkai PLUGIN = Genkai.getInstance();
    private final EnumMap<Elements, Element> elements;

    public ElementManager() {
        elements = new EnumMap<>(Elements.class);
        addElements();
    }

    private void addElements() {
        elements.put(
                Elements.MOKUTON,
                new Element(
                        "Mokuton",
                        Arrays.asList(
                                "§7- §fÉ uma alteração de natureza",
                                " §fque combina terra e água para criar madeira."
                        ),
                        Material.LOG,
                        11,
                        "manuaddp {player} genkai.select",
                        Sound.CHEST_OPEN,
                        returnItemsFromConfig("Mokuton")
                )
        );
    }

    public Collection<Element> getElements() {
        return elements.values();
    }

    private List<ItemStack> returnItemsFromConfig(String path) {

        FileConfiguration config = PLUGIN.getConfig();
        List<ItemStack> items = new ArrayList<>();

        for (String key : config.getConfigurationSection(path).getKeys(false)) {


            //item01, item02, item03
            ConfigurationSection itemSection = config.getConfigurationSection(key);

            String itemName = itemSection.getString("nome");
            int id = itemSection.getInt("id");

            ItemStack item = new ItemBuilder(Material.getMaterial(id)).setDisplayName(itemName).build();
            items.add(item);
        }

        return items;
    }


}
