package io.github.sveti404.commands;

import io.github.sveti404.mainCommands.chunkGenerator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;


public class snowCreator implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        WorldCreator wc = new WorldCreator("maailma");
        wc.generator(new chunkGenerator());
        wc.createWorld();
        if(sender instanceof Player) {
            Player player = (Player) sender;
            World maailma = Bukkit.getWorld("maailma");
            player.teleport(maailma.getSpawnLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
            return true;
        }
        return false;
    }
}
