package org.hexagonalmagmacube.LeafyBlock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getLogger;

public class LeafyBlockPlugin extends JavaPlugin {
    private static final String PLUGIN_NAME = "LeafyBlock";
    private boolean compatible;

    @Override
    public void onDisable() {
        getLogger().info(PLUGIN_NAME + ": starting Disable sequence.");
        if (compatible) {
        }
        getLogger().info(PLUGIN_NAME + " has Stopped");
    }

    @Override
    public void onEnable() {
        // TODO: Add multi-version vanilla support

        compatible = true;
        try {
            // Do some setup stuff here.
        } catch (Exception e) {
            getLogger().info(PLUGIN_NAME + ": Plugin setup failed.");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        getLogger().info(PLUGIN_NAME + " has Started");
    }
}