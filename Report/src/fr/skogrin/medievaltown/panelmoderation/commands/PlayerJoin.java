package fr.skogrin.medievaltown.panelmoderation.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.skogrin.medievaltown.panelmoderation.Main;
 

public class PlayerJoin implements Listener {
 
    private Main plugin;
 
    public PlayerJoin(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
 
        if (plugin.getConfig().getConfigurationSection("banned_players") != null) {
            for (String section : plugin.getConfig().getConfigurationSection("banned_players").getKeys(false)) {
                if (section.equals(player.getName())) {
                    player.kickPlayer(ChatColor.DARK_RED+"MEDIEVALTOWN\n"+ChatColor.RED + "Vous avez été Bannie de ce serveur, "
                    		+ "pour pouvoir être débannie faite une demande sur le discord !\n"+ ChatColor.AQUA+"Par:"
                    				+ " " +ChatColor.RED+ plugin.getConfig().getString("banned_players." + player.getName() +
                    						".banner") + ChatColor.AQUA+"\nRaison: "+ ChatColor.RED+ plugin.getConfig().getString("banned_players."
                    				+ player.getName() + ".reason"));
                }
            }
        }
    }
 
}