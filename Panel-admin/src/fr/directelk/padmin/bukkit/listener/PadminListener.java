package fr.directelk.padmin.bukkit.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;

public class PadminListener implements Listener {
	
	public boolean isRightClick​() {
		return false;
	}
	
	public boolean InventoryClickEvent​(InventoryView view, InventoryType.SlotType type, int slot, ClickType click, InventoryAction action) {
		
		
		return false;
	}
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		System.out.println("dragging detected !");
		
		@SuppressWarnings("unused")
		Player p = (Player) e.getWhoClicked();
		if (e.getClickedInventory().getName().equals(ChatColor.DARK_RED + "------Panel" + ChatColor.DARK_BLUE + " Admin------")) {
			e.setCancelled(true);
		}
	}
}
