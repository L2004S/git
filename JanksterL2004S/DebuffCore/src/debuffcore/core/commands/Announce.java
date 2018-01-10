package debuffcore.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Announce implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//Checking if the command specified is announce
		if (cmd.getName().equalsIgnoreCase("announce")) {
			if(!sender.hasPermission("k.announce")) {
				sender.sendMessage(ChatColor.RED + "Just dont even try m89");
				return true;
			}
			//Checking if there's one or more arguments
			if(args.length >= 1) {
				
				//Appending all arguments into one string
				StringBuilder strbldr = new StringBuilder();
				
				for(int i = 0;i < args.length; i++) {
					strbldr.append(args[i] + " ");
				}
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&4&m----- &c&lANNOUNCEMENT &4&m-----"));
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r" + strbldr.toString()));
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&4&m----- &c&lANNOUNCEMENT &4&m-----"));
				
			}else{
				//No message specified
				sender.sendMessage(ChatColor.RED + "No message specified try /announce <message>");
			}
			
		}
		
		return true;
	}

}
