package debuffcore.core.ranklistener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import debuffcore.core.commands.StringHolder;

public class ExaminerListener implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		
		Action cnt = e.getAction();
		Action rcb = Action.RIGHT_CLICK_BLOCK;
		Action rca = Action.RIGHT_CLICK_AIR;
		Player p = e.getPlayer();
		
		if(cnt.toString().equalsIgnoreCase(rca.toString()) || cnt.toString().equalsIgnoreCase(rcb.toString())) {
		
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', StringHolder.examiner))) {
			
				if(p.hasPermission("k.noe")) {
					p.sendMessage(ChatColor.RED + "You already have the rank Examiner or higher");
					return;
				}
			
				if(p.getItemInHand().getAmount() >= 2) {
					p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
				}else if(p.getItemInHand().getAmount() == 1) {
					p.getInventory().remove(p.getItemInHand());
				}
			
			
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + p.getName() + " examiner");
				p.sendMessage(ChatColor.GREEN + "You just claimed your EXAMINER rank");
			
			}

		}
	}
}