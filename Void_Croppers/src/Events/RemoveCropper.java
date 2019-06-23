package Events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.HashMap;
public class RemoveCropper implements Listener {
    ArrayList Croppers=Events.InstallCropper.Croppers;
	HashMap CCD=Events.InstallCropper.CropperChunkData;
	HashMap Money=org.Split.VC.Main.Money;
    @EventHandler
    public void blockBreak(BlockBreakEvent event) {
    	Block bl=event.getBlock();
    	if (Croppers.contains(bl)) {
    		Croppers.remove(bl);
    		CCD.remove(bl.getChunk());
    	}
    }
}