package debuffcore.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Rankitem implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		
		if(cmd.getName().equalsIgnoreCase("Rankitem")) {
			if(sender.hasPermission("k.RI")) {
				if(args.length == 2) {
					
					if(args[0].equalsIgnoreCase("r")) {
						if(Bukkit.getPlayer(args[1]) != null) {
							Player p = Bukkit.getPlayer(args[1]);
							
							ItemStack r = new ItemStack(Material.INK_SACK, 1,(short) 8);
							ItemMeta rm = r.getItemMeta();
							rm.setDisplayName(ChatColor.translateAlternateColorCodes('&', StringHolder.researcher));
							r.setItemMeta(rm);
							
							p.getInventory().addItem(r);
							
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("e")) {
						if(Bukkit.getPlayer(args[1]) != null) {
							Player p = Bukkit.getPlayer(args[1]);
							
							ItemStack e = new ItemStack(Material.INK_SACK, 1,(short) 9);
							ItemMeta em = e.getItemMeta();
							em.setDisplayName(ChatColor.translateAlternateColorCodes('&', StringHolder.examiner));
							e.setItemMeta(em);
							
							p.getInventory().addItem(e);
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("a")) {
						if(Bukkit.getPlayer(args[1]) != null) {
							Player p = Bukkit.getPlayer(args[1]);
							
							ItemStack a = new ItemStack(Material.INK_SACK, 1,(short) 14);
							ItemMeta am = a.getItemMeta();
							am.setDisplayName(ChatColor.translateAlternateColorCodes('&', StringHolder.analyst));
							a.setItemMeta(am);
							
							p.getInventory().addItem(a);
						}
						return true;
					}
				}
			}
		}
		return true;
	}

}
