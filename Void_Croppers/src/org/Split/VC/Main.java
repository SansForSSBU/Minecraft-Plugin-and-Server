package org.Split.VC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.Split.VC.commands.giveCropper;
import org.Split.VC.commands.showChunks;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.plugin.java.JavaPlugin;
import Events.InstallCropper;
import Events.RemoveCropper;
import Events.TakeCropper;
public class Main extends JavaPlugin {
	public static HashMap<Object,Object> Money = new HashMap<>();
	@Override
	public void onEnable() {
		this.getCommand("givecropper").setExecutor(new giveCropper());
		this.getCommand("showchunks").setExecutor(new showChunks());
		getServer().getConsoleSender().sendMessage("Void crophoppers have been enabled ");
		getServer().getPluginManager().registerEvents(new InstallCropper(), this);
		getServer().getPluginManager().registerEvents(new TakeCropper(), this);
		getServer().getPluginManager().registerEvents(new RemoveCropper(), this);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				HashMap CCD=Events.InstallCropper.CropperChunkData;
				Set keys=CCD.keySet();
				Iterator<Chunk> itr = keys.iterator();
				while(itr.hasNext()) {
					Chunk key=itr.next();
					Money.putIfAbsent(key, 0);
					Money.put(key, Integer.parseInt(CCD.get(key).toString())/100+Integer.parseInt(Money.get(key).toString()));
					getServer().getConsoleSender().sendMessage(Money.get(key).toString());
				}
			}
		}, 1, 120);
	}
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("Void crophoppers have been disabled");
	}
}
