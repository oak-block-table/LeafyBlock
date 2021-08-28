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

import static org.bukkit.Bukkit.getLogger;
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

            if (dieRoll == 1) {
                // We need to cancel the original event so that Minecraft will
                // not break the new Fire block that we place
                event.setCancelled(true);
                Location blockLocation = event.getBlock().getLocation();
                String message = String.format("Roll=%d.  Set fire at (%.1f, %.1f, %.1f)",
                        dieRoll, blockLocation.getX(), blockLocation.getY(), blockLocation.getZ());
                player.sendMessage(message);
                getLogger().info(message);
                player.getWorld().getBlockAt(blockLocation).setType(Material.FIRE);
                return;
            }

            if (dieRoll == 16) {
                String message = String.format("Roll=%d.  Apple.", dieRoll);
                player.sendMessage(message);
                getLogger().info(message);
                Location blockLocation = event.getBlock().getLocation().add(0.5, 0.5, 0.5);
                ItemStack itemToDrop = new ItemStack(Material.APPLE, 1);
                if (rand.nextInt(3) == 0) {
                    itemToDrop = new ItemStack(Material.GOLDEN_APPLE, 1);
                }
                player.getWorld().dropItemNaturally(blockLocation, itemToDrop);
                return;
            }

            if (dieRoll == 17) {
                String message = String.format("Roll=%d.  Potatoes.", dieRoll);
                player.sendMessage(message);
                getLogger().info(message);
                Location blockLocation = event.getBlock().getLocation().add(0.5, 0.5, 0.5);
                ItemStack itemToDrop = new ItemStack(Material.POTATO, 2);
                player.getWorld().dropItemNaturally(blockLocation, itemToDrop);
                return;
            }

            if (dieRoll == 18) {
                String message = String.format("Roll=%d.  Drop a diamond.", dieRoll);
                player.sendMessage(message);
                getLogger().info(message);
                Location blockLocation = event.getBlock().getLocation().add(0.5, 0.5, 0.5);
                ItemStack itemToDrop = new ItemStack(Material.DIAMOND, 1);
                player.getWorld().dropItemNaturally(blockLocation, itemToDrop);
                return;
            }

            if (dieRoll == 20) {
                getServer().broadcastMessage(String.format("Twenty is awesome.", dieRoll));
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
