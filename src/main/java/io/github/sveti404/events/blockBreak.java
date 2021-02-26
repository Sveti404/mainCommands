package io.github.sveti404.events;

import org.bukkit.Material;
import org.bukkit.block.data.type.Snow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class blockBreak implements Listener {

    @EventHandler
    public void onbreak (BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.SNOW) {
            if(event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR) {
                if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Tier 1")) {
                    event.setDropItems(false);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SNOWBALL, randomNumber(3, 6)));
                }
                else {
                    event.setDropItems(false);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SNOWBALL, randomNumber(1, 5)));
                }
            }
            else {
                event.setDropItems(false);
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COAL, randomNumber(1, 5)));
            }
        }
        else {
            if(!event.getPlayer().hasPermission("mainCommands.worldBreaker")) {
                event.setCancelled(true);
            } else {
                event.setCancelled(false);
            }
        }
    }

    public int randomNumber(int min, int max) {
        Random r = new Random();
        int randInt = r.nextInt(max - min) + min;
        return randInt;
    }
}
