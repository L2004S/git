package debuffcore.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Donate implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//Just checking if the command that they specified was donate
		if (cmd.getName().equalsIgnoreCase("donate")) {
			
			if(!sender.hasPermission("k.donate")) {
				return true;
			}
			
			//Checking if the argument is the exact length
			if(args.length != 0) {
				if(args.length != 2) {
					
					//Argument in the correct length now checking if the player does exist
					Player targetplayer = Bukkit.getPlayer(args[0]);
					
					if(targetplayer == null) {
						sender.sendMessage(ChatColor.RED + "Specified player not found.");
						return true;
					}
					
					//Player does exist, move onto the broadcast
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&c&m----- &b&lDONATOR &c&m-----"));
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&2&l" + targetplayer.getName()));
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&c&m----- &b&lDONATOR &c&m-----"));
					
				}
			}
			
		}
		
		return true;
	}

}
