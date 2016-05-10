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
package com.gmail.justbru00.epic.punish.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.punish.main.Main;
import com.gmail.justbru00.epic.punish.utils.GuiCreator;
import com.gmail.justbru00.epic.punish.utils.Messager;

public class Punish implements CommandExecutor {
	
	Main main;
	
	public Punish(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		// Start Command 
		
		if (command.getName().equalsIgnoreCase("punish")) {
			
			// Check Permission
			if (!sender.hasPermission("epicpunish.punish")) {
				Messager.msgSender("&cSorry you don't have permission.", sender);
				return true;
			}
			
			// Check Sender
			if (!(sender instanceof Player)) {
				Messager.msgSender("Sorry you must be a player to use /punish. (I didn't feel like making a text command. (Sorry?))", sender);
				return true;
			}
			
			Player player = (Player) sender;
			
			// Open GUI (Fun Stuff Starts)
			if (args.length != 1) {
				Messager.msgPlayer("&cPlease use proper syntax. /punish <playername>", player);
				return true;
			}
			
			Player target;
			
			try {
				target = Bukkit.getPlayer(args[0]);
			} catch (Exception e) {
				Messager.msgPlayer("&cThat player can't be found. (The player isn't online or you are bad at spelling.)", player);
				return true;
			}
			
			player.openInventory(GuiCreator.punishInv(target, player));	
			
			return true;
		} // End of Command
		
		return false;
	}

}
