package fr.directelk.padmin.bukkit.plugin;


import org.bukkit.plugin.java.JavaPlugin;

import fr.directelk.padmin.bukkit.commands.Commands;

public class PadminJavaPlugin extends JavaPlugin {
	private static PadminJavaPlugin instance;

	public void onEnable() {
		System.out.println("[Medievaltown-PanelAdmin] Le plugin viens de demarrer !");
		setup();

	}
	
	 public static PadminJavaPlugin getInstance() {
	        return instance;
	 }
	
	 
	 private void registerCommands(){
		 getCommand("padmin").setExecutor(new Commands());
	    }
	private void setup(){
        instance = this;
        registerCommands();
    }
	
	
	public void onDisable() {
		System.out.println("[MedievalTown-PanelAdmin] Le plugin viens de s'eteindre !");
	}
}
