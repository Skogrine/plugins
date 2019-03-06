package fr.directelk.profil.bukkit.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.directelk.profil.bukkit.commands.Commands;

public class Main extends JavaPlugin {
		
		public void onLoad() {
			System.out.println("[Medievaltown-Profil] §aLe plugin se charge !");
			
		}
		
		public void onEnable() {
			System.out.println("[Medievaltown-Profil] Le plugin viens de demarrer !");
			this.getCommand("profil").setExecutor(new Commands());

		}
		
		public void onDisable() {
			System.out.println("[MedievalTown-Profil] Le plugin viens de s'eteindre !");
		}
	
	
}
