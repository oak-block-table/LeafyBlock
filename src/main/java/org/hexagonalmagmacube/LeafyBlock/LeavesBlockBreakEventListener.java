package org.hexagonalmagmacube.LeafyBlock;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static org.bukkit.Bukkit.getServer;

public class LeavesBlockBreakEventListener implements Listener {

    private final Random rand = new Random();

    @EventHandler
    public void onEvent(BlockBreakEvent event) {
        int dieRoll = rand.nextInt(9);
        if (dieRoll % 2 == 1) {
            getServer().broadcastMessage(String.format("%d rolled. Good event,", dieRoll));
        }
        else
        {
            getServer().broadcastMessage(String.format("%d rolled. Bad event,", dieRoll));
        }
    }

}
