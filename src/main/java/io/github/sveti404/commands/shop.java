package io.github.sveti404.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class shop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GRAY + "Shop");

            ItemStack item = new ItemStack(Material.WOODEN_SHOVEL);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(ChatColor.WHITE + "Snow shovel [Tier 1]");
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);

            List<String> lore = new ArrayList<String>();
            lore.add("Not a very good shovel");
            lore.add("Gives between 3-6 snowballs");
            meta.setLore(lore);

            item.setItemMeta(meta);

            inv.setItem(10, item);

            player.openInventory(inv);
            return true;
        }

        return false;
    }
}
