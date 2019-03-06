package fr.skogrin.medievaltown.panelmoderation.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
	 
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
 
        if(e.getMessage().startsWith("$") && player.hasPermission("moderation.chat")){
 
            e.setCancelled(true);
 
            Bukkit.getOnlinePlayers().stream()
                    .filter(players -> players.hasPermission("moderation.chat"))
                    .forEach(players -> players.sendMessage("§7(§b§lSTAFF CHAT§7) §e" + player.getName() + "§f: §a" + e.getMessage().substring(1)));
 
        }
    }
}