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
public class showChunks implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Console cannot execute this command");
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("showChunks.use")) {
			p.sendMessage(Events.InstallCropper.CropperChunkData.toString());
			return true;
		} else {
			p.sendMessage("Insufficient permissions!");
			return true;
		}
	}
}
