package Events;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
public class InstallCropper implements Listener {
	HashMap Money=org.Split.VC.Main.Money;
    public static HashMap<Object, Object> CropperChunkData = new HashMap<>();//CHUNK, CACTUS
    public static ArrayList<Object> Croppers = new ArrayList<>();
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player p=event.getPlayer();
        ItemStack itemPlaced=p.getItemInHand();
        if (itemPlaced.getType()==Material.HOPPER & itemPlaced.hasItemMeta()) {
	        if  (itemPlaced.getItemMeta().getDisplayName().contentEquals(ChatColor.RESET+""+ChatColor.BOLD+ChatColor.DARK_PURPLE+"Void "+ChatColor.DARK_GREEN+"Crop hopper")) {
	        	Chunk locationPlaced=event.getBlockPlaced().getChunk();
	        	int X = locationPlaced.getX();
	        	int Z = locationPlaced.getZ();
	        	int cac=0;
	        	for (int i = 0; i<=15; i++) {
	        		for (int v = 0; v<=15; v++) {
	        			for (int j = 0; j<=255; j++) {
	        				Material blocktype = locationPlaced.getBlock(i, j, v).getType();
	        				if (blocktype==Material.CACTUS) {
	        					Material above=locationPlaced.getBlock(i, j+1, v).getType();
	        					if (above==Material.AIR) {
	        						cac=cac+1;
	        					}
	        				}
	        					
	        			}
	        		}
	        	}
	        	if (!CropperChunkData.containsKey(locationPlaced)) {
	        		CropperChunkData.put(locationPlaced,cac);
	        		Croppers.add(event.getBlockPlaced());
	        		Money.put(locationPlaced,0);
	        	}
	            p.sendMessage("X: "+ X +" Z: "+ Z +" Cactus: "+cac);
	        }
        }
    }
}