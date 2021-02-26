package io.github.sveti404.mainCommands;


import io.github.sveti404.commands.shop;
import io.github.sveti404.commands.snowCreator;
import io.github.sveti404.commands.world;
import io.github.sveti404.events.blockBreak;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class mainCommands extends JavaPlugin {

    @Override
    public void onDisable() {


    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new blockBreak(), this);
        this.getCommand("snowIsland").setExecutor(new snowCreator());
        this.getCommand("world").setExecutor(new world());
        this.getCommand("shop").setExecutor(new shop());
        new WorldCreator("maailma").createWorld();
        InputStream inputStream = getResource("snowIsland.schem");
        File schematicsFolder = new File(this.getDataFolder() + File.separator + "/schematics/");
        this.saveResource("snowIsland.schem", true);

        if(!schematicsFolder.exists()) {
            schematicsFolder.mkdirs();
        }
    }


}

