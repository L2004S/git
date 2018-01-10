package debuffcore.core.listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import debuffcore.core.commands.StringHolder;

public class FireKeyClickListener implements Listener {

	@EventHandler
	public void KeyClick(PlayerInteractEvent e) {
		
		if(e.getPlayer().getItemInHand().getType() != Material.TRIPWIRE_HOOK) {
			return;
		}
		
		if(e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) != 10) {
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', StringHolder.fire))) {
				
					if(e.getPlayer().getInventory().firstEmpty() != -1) {
					
						
						Integer first = e.getPlayer().getInventory().firstEmpty();
						
						
						e.getPlayer().getInventory().setItem(first, new ItemStack(Material.DIRT));
						
						
						if(e.getPlayer().getInventory().firstEmpty() != -1) {
							
							if(e.getPlayer().getInventory().getItemInHand().getAmount() != 1) {
								
								Integer first2 = e.getPlayer().getInventory().firstEmpty();
								
								e.getPlayer().getInventory().setItem(first2, new ItemStack(Material.DIRT));
								
								if(e.getPlayer().getInventory().firstEmpty() == -1) {
									
									e.getPlayer().getInventory().setItem(first, new ItemStack(Material.AIR));
									e.getPlayer().getInventory().setItem(first2, new ItemStack(Material.AIR));
									e.getPlayer().sendMessage(ChatColor.RED + "Not enough inventory space!");
									return;
								}
								e.getPlayer().getInventory().setItem(first2, new ItemStack(Material.AIR));
							}
							
							e.getPlayer().getInventory().setItem(first, new ItemStack(Material.AIR));
							
							
							
							
							
							
							
						if(e.getPlayer().getItemInHand().getAmount() >= 2) {
							e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() -1);
						}else{
							e.getPlayer().getInventory().remove(e.getPlayer().getItemInHand());
						}
					
						Random r = new Random();
						Random r1 = new Random();
						Random r2 = new Random();
					
						//Item stacks
						ItemStack obsidian = new ItemStack(Material.OBSIDIAN, 64);
						ItemStack tnt = new ItemStack(Material.TNT, 64);
						ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
						ItemStack cp = new ItemStack(Material.DIAMOND_CHESTPLATE);
						ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
						ItemStack boot = new ItemStack(Material.DIAMOND_BOOTS);
						ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
						ItemStack fort = new ItemStack(Material.DIAMOND_PICKAXE);
						ItemStack silk = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);
						ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 32);
						
						//Item metas
						ItemMeta obsidianmeta = obsidian.getItemMeta();
						obsidianmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&l64 Obsidian"));
						
						ItemMeta tntmeta = tnt.getItemMeta();
						tntmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l64 TNT"));
						
						ItemMeta helmmeta = helm.getItemMeta();
						helmmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l&oFire &7&lHelmet"));
						helm.setItemMeta(helmmeta);
						helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						helm.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta cpmeta = cp.getItemMeta();
						cpmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l&oFire &7&lChestplate"));
						cp.setItemMeta(cpmeta);
						cp.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						cp.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta legmeta = leg.getItemMeta();
						legmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l&oFire &7&lLeggings"));
						leg.setItemMeta(legmeta);
						leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						leg.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta bootmeta = boot.getItemMeta();
						bootmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l&oFire &7&lBoots"));
						boot.setItemMeta(bootmeta);
						boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						boot.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta swordmeta = sword.getItemMeta();
						swordmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l&oFire &7&lSword"));
						sword.setItemMeta(swordmeta);
						sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
						
						ItemMeta fortmeta = fort.getItemMeta();
						fortmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l&oFire &7&lFortune"));
						fort.setItemMeta(fortmeta);
						fort.addEnchantment(Enchantment.DIG_SPEED, 3);
						fort.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
						fort.addEnchantment(Enchantment.DURABILITY, 1);
						
						if(r.nextInt(14) == 0) {
							e.getPlayer().getInventory().addItem(gaps);
						}else if(r.nextInt(14) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r.nextInt(14) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r.nextInt(14) == 3){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "xp give " + e.getPlayer().getName() + " 2000");
						}else if(r.nextInt(14) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Zombie 2");
						}else if(r.nextInt(14) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r.nextInt(14) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r.nextInt(14) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Blaze 1");
						}else if(r.nextInt(14) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r.nextInt(14) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r.nextInt(14) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r.nextInt(14) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r.nextInt(14) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 10000");
						}else{
							e.getPlayer().getInventory().addItem(silk);
						}
						
						if(r1.nextInt(14) == 0) {
							e.getPlayer().getInventory().addItem(gaps);
						}else if(r1.nextInt(14) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r1.nextInt(14) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r1.nextInt(14) == 3){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "xp give " + e.getPlayer().getName() + " 2000");
						}else if(r1.nextInt(14) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Zombie 2");
						}else if(r1.nextInt(14) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r1.nextInt(14) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r1.nextInt(14) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Blaze 1");
						}else if(r1.nextInt(14) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r1.nextInt(14) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r1.nextInt(14) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r1.nextInt(14) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r1.nextInt(14) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 10000");
						}else{
							e.getPlayer().getInventory().addItem(silk);
						}
						
						if(r2.nextInt(14) == 0) {
							e.getPlayer().getInventory().addItem(gaps);
						}else if(r2.nextInt(14) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r2.nextInt(14) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r2.nextInt(14) == 3){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "xp give " + e.getPlayer().getName() + " 2000");
						}else if(r2.nextInt(14) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Zombie 2");
						}else if(r2.nextInt(14) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r2.nextInt(14) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r2.nextInt(14) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Blaze 1");
						}else if(r2.nextInt(14) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r2.nextInt(14) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r2.nextInt(14) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r2.nextInt(14) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r2.nextInt(14) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 10000");
						}else{
							e.getPlayer().getInventory().addItem(silk);
						}
				
					}else{
						e.getPlayer().getInventory().setItem(first, new ItemStack(Material.AIR));
						e.getPlayer().sendMessage(ChatColor.RED + "Not enough inventory space!");
					}
				
				
				}
			}
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == StringHolder.fire) {
				
				e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() -1);
				
				
			}
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == StringHolder.god) {
				
				e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() -1);
				
				
			}
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == StringHolder.supreme) {
				
				e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() -1);
				
				
			}
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == StringHolder.koth) {
				
			}
		}
		return;
	}
	
}
