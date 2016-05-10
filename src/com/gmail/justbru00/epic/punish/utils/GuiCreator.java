/**
 * MIT License

Copyright (c) 2016 Justin "JustBru00" Brubaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.gmail.justbru00.epic.punish.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GuiCreator {

	public static Inventory punishInv(Player target, Player sender) {
		Inventory i = Bukkit.createInventory(null, 27, Messager.color("&bPunishing: &7" + target.getName()));
		
		// Add Items
		i.setItem(4, ItemMaker.createSkull(target.getName(), "&cYou are punishing &7" + target.getName()));
		i.setItem(12, ItemMaker.createItemStack("&fChat Offences", Material.BOOK_AND_QUILL.toString()));
		i.setItem(14, ItemMaker.createItemStack("&fGameplay Offences", Material.TNT.toString()));
		i.setItem(26, ItemMaker.createItemStack("&cClose", Material.BARRIER.toString()));
		
		return i;		
	}
	
}
