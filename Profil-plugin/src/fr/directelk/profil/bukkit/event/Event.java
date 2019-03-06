package fr.directelk.profil.bukkit.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Event implements Listener {
	
	@EventHandler
	public void onInteract(InventoryClickEvent e) {
		System.out.println("test");
	    Player player = (Player) e.getWhoClicked();
	    if (e.getInventory().getName().equals(ChatColor.DARK_RED + "Profil de " + ChatColor.BLUE + player.getName())) {
	        
	        
	    }
	}
	
}
