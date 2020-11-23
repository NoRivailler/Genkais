package com.moon.degust.genkai.objects;

import com.moon.degust.genkai.builder.items.ItemBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@AllArgsConstructor
@Data
public class Element {

    private String name;
    private List<String> lore;

    private Material materialBase;
    private int slotBase;

    @Getter(AccessLevel.NONE)
    private String command;
    private Sound customSoundOnChoose;

    private List<ItemStack> itemsOnChoose;



    public ItemStack getItem() {
        return new ItemBuilder(materialBase).setDisplayName(name).setLore(lore).build();
    }

    public String getCommand(Player player) {
        return command.replace("{player}", player.getName());
    }

}
