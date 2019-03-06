package fr.skogrin.medievaltown.rank.bukkit.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.skogrin.medievaltown.rank.Rank;
import fr.skogrin.medievaltown.rank.bukkit.listerners.PlayerListener;

public final class RankJavaPlugin extends JavaPlugin {

	private Rank rank;

	public final void onLoad() {
		rank = new Rank(this);
	}
	
	public final void onEnable() {
		rank.initConfig();
		rank.initScoreboard();
		
		Bukkit.getPluginManager().registerEvents(new PlayerListener(rank), this);
	}
	

	public final void onDisable() {

	}
	
	
}
