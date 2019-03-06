package fr.skogrin.medievaltown.luckyblock;

import org.bukkit.plugin.java.JavaPlugin;

import fr.skogrin.medievaltown.luckyblock.commands.LbCommand;
import fr.skogrin.medievaltown.luckyblock.listeners.LuckyBlockListener;

public class Main extends JavaPlugin {

	public void onEnable() {
		System.out.println("[LuckyBlockMT] Vient de s'allumer !");
		getServer().getPluginManager().registerEvents(new LuckyBlockListener(this), this);
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getCommand("lb").setExecutor(new LbCommand());

	}

	public void onDisable() {
		System.out.println("[LuckyBlockMT] Vient de s'eteindre !");
	}

}
