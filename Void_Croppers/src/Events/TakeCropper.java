package Events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.Split.VC.Main;

import java.util.ArrayList;
import java.util.HashMap;
import Events.InstallCropper;
public class TakeCropper implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
    	ArrayList Croppers=Events.InstallCropper.Croppers;
    	HashMap CCD=Events.InstallCropper.CropperChunkData;
    	HashMap Money=org.Split.VC.Main.Money;
    	Bukkit.getServer().getConsoleSender().sendMessage(Money.toString());
    	Block b=event.getClickedBlock();
    	if (!(b==null)) {
	    	if (b.getType()==Material.HOPPER) {
	        	if (Croppers.contains(b)) {
	        		int CactusInHopper=Integer.parseInt(Money.get(b.getChunk()).toString());
	        		if (CactusInHopper>0) {
	        			PlayerInventory inv=event.getPlayer().getInventory();
	        			for(int slot = 0; slot < inv.getSize(); slot++) {
	        			    if(inv.getItem(slot) == null) {
	        			    	if (CactusInHopper>=64) {
	        			    		inv.setItem(slot,new ItemStack(Material.CACTUS,64) );
	        			    		CactusInHopper=CactusInHopper-64;
	        			    	}
	        			    	else {
	        			    		if (CactusInHopper>0) {
		        			    		inv.setItem(slot, new ItemStack(Material.CACTUS,CactusInHopper));
		        			    		CactusInHopper=0;
	        			    		}
	        			    	}
	        			    }
	        			}
	        		}
	        		Money.put(b.getChunk(), CactusInHopper);
	        	}
	    	}
    	} 
    }
}