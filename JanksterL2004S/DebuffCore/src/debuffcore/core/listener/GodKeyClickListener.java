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

public class GodKeyClickListener implements Listener {

	@EventHandler
	public void KeyClick(PlayerInteractEvent e) {
		
		if(e.getPlayer().getItemInHand().getType() != Material.TRIPWIRE_HOOK) {
			return;
		}
		
		if(e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) != 10) {
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', StringHolder.god))) {
				
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
						ItemStack obsidian = new ItemStack(Material.GOLDEN_APPLE, 64);
						ItemStack tnt = new ItemStack(Material.GOLDEN_APPLE, 5, (short)1);
						ItemStack cegg = new ItemStack(Material.MONSTER_EGG, 10, (short) 50);
						ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
						ItemStack cp = new ItemStack(Material.DIAMOND_CHESTPLATE);
						ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
						ItemStack boot = new ItemStack(Material.DIAMOND_BOOTS);
						ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
						ItemStack loot = new ItemStack(Material.DIAMOND_SWORD);
						ItemStack fort = new ItemStack(Material.DIAMOND_PICKAXE);
						ItemStack silk = new ItemStack(Material.DIAMOND_PICKAXE);
						
						//Item metas
						
						ItemMeta ceggmeta = cegg.getItemMeta();
						ceggmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&l10 Creeper Eggs"));
						
						ItemMeta helmmeta = helm.getItemMeta();
						helmmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lHelmet"));
						helm.setItemMeta(helmmeta);
						helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
						helm.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						
						ItemMeta cpmeta = cp.getItemMeta();
						cpmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lChestplate"));
						cp.setItemMeta(cpmeta);
						cp.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
						cp.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						
						ItemMeta legmeta = leg.getItemMeta();
						legmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lLeggings"));
						leg.setItemMeta(legmeta);
						leg.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
						leg.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						
						ItemMeta bootmeta = boot.getItemMeta();
						bootmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lBoots"));
						boot.setItemMeta(bootmeta);
						boot.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
						boot.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						
						ItemMeta swordmeta = sword.getItemMeta();
						swordmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lSword"));
						sword.setItemMeta(swordmeta);
						sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
						sword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
						
						ItemMeta lootmeta = loot.getItemMeta();
						lootmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lLooting"));
						loot.setItemMeta(swordmeta);
						loot.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
						loot.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						loot.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 5);
						
						ItemMeta fortmeta = fort.getItemMeta();
						fortmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lFortune"));
						fort.setItemMeta(fortmeta);
						fort.addUnsafeEnchantment(Enchantment.DIG_SPEED, 6);
						fort.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4);
						fort.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						
						ItemMeta silkmeta = silk.getItemMeta();
						silkmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r&l&oGod &7&lPickaxe"));
						silk.setItemMeta(silkmeta);
						silk.addUnsafeEnchantment(Enchantment.DIG_SPEED, 6);
						silk.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
						
						if(r.nextInt(16) == 0) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rankitem a " + e.getPlayer().getName());
						}else if(r.nextInt(16) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r.nextInt(16) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r.nextInt(16) == 3){
							e.getPlayer().getInventory().addItem(cegg);
						}else if(r.nextInt(16) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " blaze 3");
						}else if(r.nextInt(16) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r.nextInt(16) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r.nextInt(16) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " irongolem 1");
						}else if(r.nextInt(16) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r.nextInt(16) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r.nextInt(16) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r.nextInt(16) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r.nextInt(16) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 50000");
						}else if(r.nextInt(16) == 13){
							e.getPlayer().getInventory().addItem(silk);
						}else if(r.nextInt(16) == 14){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " villager 1");
						}else{
							e.getPlayer().getInventory().addItem(loot);
						}
						
						if(r1.nextInt(16) == 0) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rankitem a " + e.getPlayer().getName());
						}else if(r1.nextInt(16) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r1.nextInt(16) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r1.nextInt(16) == 3){
							e.getPlayer().getInventory().addItem(cegg);
						}else if(r1.nextInt(16) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " blaze 3");
						}else if(r1.nextInt(16) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r1.nextInt(16) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r1.nextInt(16) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " irongolem 1");
						}else if(r1.nextInt(16) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r1.nextInt(16) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r1.nextInt(16) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r1.nextInt(16) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r1.nextInt(16) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 50000");
						}else if(r1.nextInt(16) == 13){
							e.getPlayer().getInventory().addItem(silk);
						}else if(r1.nextInt(16) == 14){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " villager 1");
						}else{
							e.getPlayer().getInventory().addItem(loot);
						}
						
						if(r2.nextInt(16) == 0) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rankitem a " + e.getPlayer().getName());
						}else if(r2.nextInt(16) == 1){
							e.getPlayer().getInventory().addItem(obsidian);
						}else if(r2.nextInt(16) == 2){
							e.getPlayer().getInventory().addItem(tnt);
						}else if(r2.nextInt(16) == 3){
							e.getPlayer().getInventory().addItem(cegg);
						}else if(r2.nextInt(16) == 4){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " blaze 3");
						}else if(r2.nextInt(16) == 5){
							e.getPlayer().getInventory().addItem(helm);
						}else if(r2.nextInt(16) == 6){	
							e.getPlayer().getInventory().addItem(cp);
						}else if(r2.nextInt(16) == 7){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " irongolem 1");
						}else if(r2.nextInt(16) == 8){	
							e.getPlayer().getInventory().addItem(leg);
						}else if(r2.nextInt(16) == 9){
							e.getPlayer().getInventory().addItem(boot);
						}else if(r2.nextInt(16) == 10){	
							e.getPlayer().getInventory().addItem(sword);
						}else if(r2.nextInt(16) == 11){
							e.getPlayer().getInventory().addItem(fort);
						}else if(r2.nextInt(16) == 12){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + e.getPlayer().getName() + " 50000");
						}else if(r2.nextInt(16) == 13){
							e.getPlayer().getInventory().addItem(silk);
						}else if(r2.nextInt(16) == 14){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "silkspawners give " + e.getPlayer().getName() + " villager 1");
						}else{
							e.getPlayer().getInventory().addItem(loot);
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
