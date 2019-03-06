package fr.skogrin.medievaltown.vote.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
 
public class InventoryClick implements Listener {
 
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;
 
        Player player = (Player) e.getWhoClicked();
 
        switch(e.getCurrentItem().getType()){
 
            case IRON_SWORD:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aServeurs-minecraft")){
                    e.setCancelled(true);
                    player.closeInventory();
                    player.sendMessage("§b[Médiévaltown] §aVérification du vote...");
                }
                break;
 
            case FEATHER:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aTopg")){
                    e.setCancelled(true);
                    player.closeInventory();
                    player.sendMessage("§b[Médiévaltown] §aVérification du vote...");
                }
                break;
            case BARRIER:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cRetour")){
                    e.setCancelled(true);
                    player.closeInventory();
                    player.sendMessage("§b[Médiévaltown] §cFermeture du panel de vote !");
                }
                break;
            default: break;
        }
    }
}
