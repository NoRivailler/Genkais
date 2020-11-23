package com.moon.degust.genkai.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@AllArgsConstructor
@Data
public class Element {

    private String name;
    private List<String> lore;

    private Material materialBase;
    private int slotBase;

    private String command;
    private Sound customSoundOnChoose;

    private List<ItemStack> itemsOnChoose;



}
