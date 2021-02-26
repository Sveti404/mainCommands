package io.github.sveti404.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class world implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("mainCommands.world.tp")) {
                if(Bukkit.getWorld(args[0]) != null) {

                    World world = Bukkit.getWorld(args[0]);
                    if(player.getWorld() != world) {
                        player.teleport(world.getSpawnLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
                        return true;
                    } else {
                        player.sendMessage("Can't teleport to same world");
                    }
                } else {
                    player.sendMessage("World not found");
                    return false;

                }

            }
            return false;

        }
        return false;
    }
}
