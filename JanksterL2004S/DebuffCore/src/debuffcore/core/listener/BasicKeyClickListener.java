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

public class BasicKeyClickListener implements Listener {

	@EventHandler
	public void KeyClick(PlayerInteractEvent e) {
		
		if(e.getPlayer().getItemInHand().getType() != Material.TRIPWIRE_HOOK) {
			return;
		}
		
		if(e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) != 10) {
			return;
		}
		
		Action rca = Action.RIGHT_CLICK_AIR;
		Action rcb = Action.RIGHT_CLICK_BLOCK;
		Action cnt = e.getAction();
		
		if(cnt.equals(rca) || cnt.equals(rcb)) {
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', StringHolder.basic))) {
				
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
						ItemStack cegg = new ItemStack(Material.MONSTER_EGG, 1, (short) 50);
						ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
						ItemStack cp = new ItemStack(Material.DIAMOND_CHESTPLATE);
						ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
						ItemStack boot = new ItemStack(Material.DIAMOND_BOOTS);
						ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
						ItemStack fort = new ItemStack(Material.DIAMOND_PICKAXE);
						ItemStack silk = new ItemStack(Material.DIAMOND_PICKAXE);
						
						//Item metas
						ItemMeta obsidianmeta = obsidian.getItemMeta();
						obsidianmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&l64 Obsidian"));
						
						ItemMeta tntmeta = tnt.getItemMeta();
						tntmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&l64 TNT"));
						
						ItemMeta ceggmeta = cegg.getItemMeta();
						ceggmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&l1 Creeper Egg"));
						
						ItemMeta helmmeta = helm.getItemMeta();
						helmmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l&oBasic &7&lHelmet"));
						helm.setItemMeta(helmmeta);
						helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						helm.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta cpmeta = cp.getItemMeta();
						cpmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l&oBasic &7&lChestplate"));
						cp.setItemMeta(cpmeta);
						cp.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						cp.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta legmeta = leg.getItemMeta();
						legmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l&oBasic &7&lLeggings"));
						leg.setItemMeta(legmeta);
						leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						leg.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta bootmeta = boot.getItemMeta();
						bootmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l&oBasic &7&lBoots"));
						boot.setItemMeta(bootmeta);
						boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						boot.addEnchantment(Enchantment.DURABILITY, 1);
						
						ItemMeta swordmeta = sword.getItemMeta();
						swordmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l&oBasic &7&lSword"));
						sword.setItemMeta(swordmeta);
						sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
						
						ItemMeta fortmeta = fort.getItemMeta();
						fortmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l&oBasic &7&lFortune"));
						fort.setItemMeta(fortmeta);
						fort.addEnchantment(Enchantment.DIG_SPEED, 1);
						fort.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
						
						ItemMeta silkmeta = silk.getItemMeta();
						silkmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l&oBasic &7&lSilk Touch"));
						silk.setItemMeta(silkmeta);
						silk.addEnchantment(Enchantment.DIG_SPEED, 1);
						silk.addEnchantment(Enchantment.SILK_TOUCH, 1);
						
						
						if(r.nextInt(15) == 0) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crates give fire " + e.getPlayer().getName());
						}else if(r.nextInt(15) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r.nextInt(15) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r.nextInt(15) == 3){
							e.getPlayer().getInventory().addItem(cegg);
						}else if(r.nextInt(15) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Zombie 1");
						}else if(r.nextInt(15) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r.nextInt(15) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r.nextInt(15) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Skeleton 1");
						}else if(r.nextInt(15) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r.nextInt(15) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r.nextInt(15) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r.nextInt(15) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r.nextInt(15) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 5000");
						}else if(r.nextInt(15) == 13){
							e.getPlayer().getInventory().addItem(silk);
						}else{
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "xp give " + e.getPlayer().getName() + " 500");
						}
						
						if(r.nextInt(15) == 0) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crates give fire " + e.getPlayer().getName());
						}else if(r1.nextInt(15) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r1.nextInt(15) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r1.nextInt(15) == 3){
							e.getPlayer().getInventory().addItem(cegg);
						}else if(r1.nextInt(15) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Zombie 1");
						}else if(r1.nextInt(15) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r1.nextInt(15) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r1.nextInt(15) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Skeleton 1");
						}else if(r1.nextInt(15) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r1.nextInt(15) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r1.nextInt(15) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r1.nextInt(15) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r1.nextInt(15) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 5000");
						}else if(r1.nextInt(15) == 13){
							e.getPlayer().getInventory().addItem(silk);
						}else if(r1.nextInt(15) == 14){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "xp give " + e.getPlayer().getName() + " 500");
						}
						
						if(r2.nextInt(15) == 0) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crates give fire " + e.getPlayer().getName());
						}else if(r2.nextInt(15) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r2.nextInt(15) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r2.nextInt(15) == 3){
							e.getPlayer().getInventory().addItem(cegg);
						}else if(r2.nextInt(15) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Zombie 1");
						}else if(r2.nextInt(15) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r2.nextInt(15) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r2.nextInt(15) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " Skeleton 1");
						}else if(r2.nextInt(15) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r2.nextInt(15) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r2.nextInt(15) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r2.nextInt(15) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r2.nextInt(15) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 5000");
						}else if(r2.nextInt(15) == 13){
							e.getPlayer().getInventory().addItem(silk);
						}else{
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "xp give " + e.getPlayer().getName() + " 500");
						}
						
						return;
				
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
