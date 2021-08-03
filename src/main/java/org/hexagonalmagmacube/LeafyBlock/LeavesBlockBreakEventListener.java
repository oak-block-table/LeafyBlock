package org.hexagonalmagmacube.LeafyBlock;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static org.bukkit.Bukkit.getServer;

public class LeavesBlockBreakEventListener implements Listener {

    private final Random rand = new Random();

    @EventHandler
    public void onEvent(BlockBreakEvent event) {
        int dieRoll = rand.nextInt(20);
        if (dieRoll == 0) {
            Player player = event.getPlayer();
            getServer().broadcastMessage(String.format("Natural 0. Watch out %s.", player.getDisplayName()));
            // player.setHealth(0);
            // event.getPlayer().kickPlayer("Natural zero.");
            TNTPrimed tnt = player.getWorld().spawn(player.getLocation(), TNTPrimed.class);
            tnt.setFuseTicks(80);
            return;
        }
        if (dieRoll == 20) {
            getServer().broadcastMessage(String.format("Twenty is awesome.", dieRoll));
        }

        if (dieRoll % 2 == 1) {
            getServer().broadcastMessage(String.format("%d rolled. Good event,", dieRoll));
        }
        else
        {
            getServer().broadcastMessage(String.format("%d rolled. Bad event,", dieRoll));
        }
    }

}
