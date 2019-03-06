package fr.skogrin.medievaltown.scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener {

	public Map<Player, ScoreboardSign> boards = new HashMap<>();
	

	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	
	

	@EventHandler
	public void onJoin(PlayerJoinEvent pje) {
		Player player = pje.getPlayer();

		
		for(Entry<Player, ScoreboardSign> sign : boards.entrySet()) {
			sign.getValue().setLine(9, "§7Joueurs :§5 "+Bukkit.getOnlinePlayers().size()+ "/" + Bukkit.getMaxPlayers());
		}
		ScoreboardSign sb = new ScoreboardSign(player, "§b§lMédiévalTown");
		sb.create();
		sb.setLine(1, "§1 ");
		sb.setLine(2, "§7Pseudo : §a" + player.getName());
		sb.setLine(3, "§7Grade : §cIndisponible");
		sb.setLine(4, "§7Coins :");
		sb.setLine(5, "§7Ecus :");
		sb.setLine(6, "§3 ");
		sb.setLine(7, "§2 ");
		sb.setLine(8, "§7Lobby : §5#1");
		sb.setLine(9, "§7Joueurs :§5 " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
		sb.setLine(10, "§9 ");
		sb.setLine(11, "§6§lplay.medievaltown.fr");
		boards.put(player, sb);
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent pqe) {
		Player player = pqe.getPlayer();
		
		for(Entry<Player, ScoreboardSign> sign : boards.entrySet()) {
			sign.getValue().setLine(9, "§7Joueurs :§5 "+(Bukkit.getOnlinePlayers().size() - 1)+ "/" + Bukkit.getMaxPlayers());
		}
		
		if(boards.containsKey(player)) {
			boards.get(player).destroy();
		}
	}
	
}
