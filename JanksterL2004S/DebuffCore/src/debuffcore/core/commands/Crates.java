package debuffcore.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Crates implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
			
			
			//Checking if the command is /crates
			if(cmd.getName().equalsIgnoreCase("crates")) {
				
				if(!sender.hasPermission("k.crates")) {
					sender.sendMessage(ChatColor.RED + "No... just no");
					return true;
				}
				
				if(args.length == 4) {
					
					if(Integer.parseInt(args[3]) == -1) {
						sender.sendMessage(ChatColor.RED + "dumbo you gotta put a number at the last argument no characters...");
						return true;
					}
					
					Integer amount = Integer.parseInt(args[3]);
					
					//Checking if the first argument is /crates give
					if(args[0].equalsIgnoreCase("give")) {
						
						if(Bukkit.getPlayer(args[2]) == null && !args[2].equalsIgnoreCase("all")) {
							sender.sendMessage(ChatColor.RED + "Player not found!");
						}
						Player targetp = Bukkit.getPlayer(args[2]);
						
						//Checking what crate you want key too
						if(args[1].equalsIgnoreCase("basic")) {
							
							String name = StringHolder.basic;
							
							ItemStack basickey = new ItemStack(Material.TRIPWIRE_HOOK, 1);
							ItemMeta basickeymeta = basickey.getItemMeta();
							basickeymeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
							basickey.setItemMeta(basickeymeta);
							basickey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
							
							if(args[2].equalsIgnoreCase("all")) {
								
								for(Player p : Bukkit.getOnlinePlayers()) {
									for(int i = 0;i < amount; i++)	{
										p.getInventory().addItem(basickey);
										}
								}
								
								return true;
							}
							
							for(int i = 0;i < amount; i++)	{
							targetp.getInventory().addItem(basickey);
							}
							return true;
						}
						if(args[1].equalsIgnoreCase("fire")) {
							
							String name = StringHolder.fire;
							
							ItemStack firekey = new ItemStack(Material.TRIPWIRE_HOOK, 1);
							ItemMeta firekeymeta = firekey.getItemMeta();
							firekeymeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
							firekey.setItemMeta(firekeymeta);
							firekey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
							
							for(int i = 0;i < amount; i++)	{
							targetp.getInventory().addItem(firekey);
							}
							
							return true;
						}
						if(args[1].equalsIgnoreCase("supreme")) {
							
							String name = StringHolder.supreme;
							
							ItemStack supremekey = new ItemStack(Material.TRIPWIRE_HOOK, 1);
							ItemMeta supremekeymeta = supremekey.getItemMeta();
							supremekeymeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
							supremekey.setItemMeta(supremekeymeta);
							supremekey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
							
							for(int i = 0;i < amount; i++)	{
							targetp.getInventory().addItem(supremekey);
							}
							
							return true;
						}
						if(args[1].equalsIgnoreCase("god")) {
							
							String name = StringHolder.god;
							
							ItemStack godkey = new ItemStack(Material.TRIPWIRE_HOOK, 1);
							ItemMeta godkeymeta = godkey.getItemMeta();
							godkeymeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
							godkey.setItemMeta(godkeymeta);
							godkey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
							
							for(int i = 0;i < amount; i++)	{
							targetp.getInventory().addItem(godkey);
							}
							
							return true;
						}
						if(args[1].equalsIgnoreCase("koth")) {
							
							String name = StringHolder.koth;
							
							ItemStack kothkey = new ItemStack(Material.INK_SACK, 1);
							ItemMeta kothkeymeta = kothkey.getItemMeta();
							kothkeymeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
							kothkey.setItemMeta(kothkeymeta);
							kothkey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
							
							for(int i = 0;i < amount; i++)	{
							targetp.getInventory().addItem(kothkey);
							}
								
							return true;
						}
						
						sender.sendMessage("Invalid crate");
						return true;
					}
				
				}
				
				if(args.length == 1) {
					//Checking if the first argument is /crates help
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(ChatColor.RED + "dumbo its /crates give (basic/fire/supreme/god/koth) <playername> <amount> god you must be stupid");
						return true;
					}
				}
			
				sender.sendMessage(ChatColor.RED + "Wrong syntax. /crates help");
				
				}
		
		return true;
	}

}
