package org.hexagonalmagmacube.LeafyBlock;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getServer;

public class LeavesBlockBreakEventListener implements Listener {

    private final Random rand = new Random();

    @EventHandler
    public void onEvent(BlockBreakEvent event) {
        Material material = event.getBlock().getType();
        if (material == Material.ACACIA_LEAVES || material == Material.AZALEA_LEAVES
            || material == Material.BIRCH_LEAVES || material == Material.DARK_OAK_LEAVES
            || material == Material.FLOWERING_AZALEA_LEAVES || material == Material.JUNGLE_LEAVES
            || material == Material.OAK_LEAVES || material == Material.SPRUCE_LEAVES)
        {
            int dieRoll = rand.nextInt(20);
            Player player = event.getPlayer();
            if (dieRoll == 0) {
                getServer().broadcastMessage(String.format("Roll=%d. Watch out %s.", dieRoll, player.getDisplayName()));
                // player.setHealth(0);
                // event.getPlayer().kickPlayer("Natural zero.");
                TNTPrimed tnt = player.getWorld().spawn(player.getLocation(), TNTPrimed.class);
                tnt.setFuseTicks(80);
                return;
            }
            if (dieRoll == 20) {
                getServer().broadcastMessage(String.format("Twenty is awesome.", dieRoll));
                return;
            }

            if (dieRoll == 18) {
                player.sendMessage(String.format("Roll=%d.  Drop a diamond.", dieRoll));
                Location blockLocation = event.getBlock().getLocation().add(0.5, 0.5, 0.5);
                ItemStack itemToDrop = new ItemStack(Material.DIAMOND, 1);
                player.getWorld().dropItemNaturally(blockLocation, itemToDrop);
                return;
            }

            if (dieRoll <= 17) {
                // player.sendMessage(String.format("Roll=%d.  Fire.", dieRoll));
                // event.getBlock().setType(Material.FIRE);
                return;
            }

//        if (dieRoll % 2 == 1) {
//            getServer().broadcastMessage(String.format("%d rolled. Good event,", dieRoll));
//        }
//        else
//        {
//            getServer().broadcastMessage(String.format("%d rolled. Bad event,", dieRoll));
//        }
        }
    }
}
