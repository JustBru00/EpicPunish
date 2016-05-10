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

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.justbru00.epic.punish.main.Main;
import com.gmail.justbru00.epic.punish.utils.Messager;

public class EpicPunish implements CommandExecutor {

	Main main;
	
	public EpicPunish(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("epicpunish")) {
			if (!sender.hasPermission("epicpunish.epicpunish"))  {
				Messager.msgSender("&cSorry you do not have permission to use that command.", sender);
				return true;
			}
			
			if (args.length != 1) {
				Messager.msgSender("&cPlease use proper arguments. /epicpunish <debug, version>", sender);
				return true;
			}
			
			if (args[0].equalsIgnoreCase("debug")) {
				if (Main.debug) {
					Main.debug = false;					
				} else {
					Main.debug = true;
				}
				Messager.msgSender("&fChanged Debug Mode to: &b" + Main.debug, sender);
				return true;
			} else if (args[0].equalsIgnoreCase("version")) {
				Messager.msgSender("&fYou are running version &b" + main.VERSION, sender);
				return true;
			}
			
			return true;
		}
		
      return false;
	}

}
