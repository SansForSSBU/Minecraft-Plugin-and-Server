package org.Split.VC.commands;

import java.util.ArrayList;

import org.Split.VC.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class giveCropper implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Console cannot execute this command");
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("giveCropper.use")) {
			ItemStack cropper = new ItemStack(Material.HOPPER, 1);
			ItemMeta itemmeta = cropper.getItemMeta();
			itemmeta.setDisplayName(ChatColor.RESET+""+ChatColor.BOLD+ChatColor.DARK_PURPLE+"Void "+ChatColor.DARK_GREEN+"Crop hopper");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.RESET+""+ChatColor.BOLD+ChatColor.LIGHT_PURPLE+"Loads the chunk it is in, and automatically sells cactus.");
			itemmeta.setLore(lore);
			cropper.setItemMeta(itemmeta);
			p.getInventory().addItem(cropper);
			return true;
		} else {
			p.sendMessage("Insufficient permissions!");
			return true;
		}
	}
}
