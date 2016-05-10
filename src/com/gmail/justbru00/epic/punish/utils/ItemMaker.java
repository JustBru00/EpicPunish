package com.gmail.justbru00.epic.punish.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;


public class ItemMaker {

	public static ItemStack createItemStack(String nocolordisplayname, String material, String lore, String lore2) {
		Material m = Material.getMaterial(material);
		ItemStack is = new ItemStack(m);		
		ItemMeta im = is.getItemMeta();
		
		im.setDisplayName(Messager.color(nocolordisplayname));
		
		ArrayList<String> lorelist = new ArrayList<String>();
		lorelist.add(Messager.color(lore));
		lorelist.add(Messager.color(lore2));
		
		im.setLore(lorelist);
		
		is.setItemMeta(im);
		
		return is;
	}
	
	public static ItemStack createItemStack(String nocolordisplayname, String material) {
		Material m = Material.getMaterial(material);
		ItemStack is = new ItemStack(m);		
		ItemMeta im = is.getItemMeta();
		
		im.setDisplayName(Messager.color(nocolordisplayname));

		
		is.setItemMeta(im);
		
		return is;
	}
	
	public static ItemStack createSkull(String owner, String noncoloredDisplayName) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sm = (SkullMeta) is.getItemMeta();		
		sm.setOwner(owner);
		sm.setDisplayName(Messager.color(noncoloredDisplayName));
		is.setItemMeta(sm);		
		return is;		
	}
	
	public static ItemStack createSkullwithLore(String noncoloredDisplayName, String owner, String lore) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sm = (SkullMeta) is.getItemMeta();		
		sm.setOwner(owner);
		ArrayList<String> reallore = new ArrayList<String>();
		reallore.add(Messager.color(lore));
		sm.setDisplayName(Messager.color(noncoloredDisplayName));
		sm.setLore(reallore);
		is.setItemMeta(sm);		
		return is;		
	}
}
