package debuffcore.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import debuffcore.core.commands.Announce;
import debuffcore.core.commands.Crates;
import debuffcore.core.commands.Donate;
import debuffcore.core.commands.Rankitem;
import debuffcore.core.listener.BasicKeyClickListener;
import debuffcore.core.listener.FireKeyClickListener;
import debuffcore.core.listener.GodKeyClickListener;
import debuffcore.core.listener.SupremeKeyClickListener;
import debuffcore.core.ranklistener.AnalystListener;
import debuffcore.core.ranklistener.ExaminerListener;
import debuffcore.core.ranklistener.ResearcherListener;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		//command executors being set!
		getCommand("announce").setExecutor(new Announce());
		getCommand("donate").setExecutor(new Donate());
		getCommand("crates").setExecutor(new Crates());
		getCommand("rankitem").setExecutor(new Rankitem());
		
		//Listeners being set!
		Bukkit.getPluginManager().registerEvents(new BasicKeyClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new FireKeyClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new GodKeyClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new SupremeKeyClickListener(), this);
		
		Bukkit.getPluginManager().registerEvents(new AnalystListener(), this);
		Bukkit.getPluginManager().registerEvents(new ExaminerListener(), this);
		Bukkit.getPluginManager().registerEvents(new ResearcherListener(), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}

}
