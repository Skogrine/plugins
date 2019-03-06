package fr.skogrin.medievaltown.vote;

import org.bukkit.plugin.java.JavaPlugin;

import fr.skogrin.medievaltown.vote.commands.Commands;



public class Main extends JavaPlugin{
	 private static Main instance;
	
	@Override
	public void onEnable() {
		setup();
	}
	
	public static Main getInstance() {
		return instance;
	}
	
    private void setup(){
    	System.out.println("[VoteMT] Le plugins viens de se lancer correctement !");
        instance = this;
        registerCommands();
    }
	
	
	@Override
	public void onDisable() {
		setup2();
	}
	
	private void setup2(){
    	System.out.println("[VoteMT] Le plugins viens de se lancer correctement !");
    }
	
	private void registerCommands(){
        getCommand("vote").setExecutor(new Commands());
    }
	
}
