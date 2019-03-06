package fr.skogrin.medievaltown.panelmoderation.manager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.skogrin.medievaltown.panelmoderation.Main;
import fr.skogrin.medievaltown.panelmoderation.listeners.InventoryClick;
import fr.skogrin.medievaltown.panelmoderation.utils.ModCancels;

public class EventsManager {
	 
    public void registers(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new InventoryClick(), Main.getInstance());
        pm.registerEvents(new ModCancels(), Main.getInstance());
    }
}
