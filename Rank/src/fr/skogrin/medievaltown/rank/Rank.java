package fr.skogrin.medievaltown.rank;


import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.google.common.collect.Maps;

public final class Rank {
	
	private Scoreboard sb;
	private final Plugin plugin;
	private final Map<String, RankList> playerRanks = Maps.newHashMap();
	
	private FileConfiguration config;
	private File file;
	
	public Rank(Plugin plugin) {
		this.plugin = plugin;
		initConfig();
	}
	
	public final Plugin getPlugin() {
		return plugin;
	}
	
	public final Scoreboard getSb() {
		return sb;
	}
	
	
	public void initConfig() {
		File f = new File("plugins/RankMT");
		if(!f.exists()) f.mkdirs();
		file = new File(f, "Grades_Players.yml");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException error){error.printStackTrace();}
		}
		
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public void changePlayer(Player player) {
		String uuid = player.getPlayer().getUniqueId().toString();
		if(playerRanks.containsKey(player.getUniqueId().toString())) return;
		if(!config.contains(uuid)) {
			String grade = String.valueOf(RankList.valueOf(null, uuid));
			config.set(uuid, grade);
			saveConfig();
		}
	}
	
	
	public void initScoreboard() {
		if(sb != null) throw new UnsupportedOperationException("Le scoreboard nest pas set !");
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		
		for(RankList rankList : RankList.values()) {
			Team team = sb.registerNewTeam(rankList.getName());
			team.setPrefix(rankList.getPrefix());
			team.setSuffix(rankList.getSuffix());
		}
	}
	
	public void loadPlayer(Player player) {
		String uuid = player.getPlayer().getUniqueId().toString();
		if(playerRanks.containsKey(player.getUniqueId().toString())) return;
		if(!config.contains(uuid)) {
			config.set(uuid, 1);
			saveConfig();
		}
		
		
		playerRanks.put(uuid, getRankById(config.getInt(uuid)));
		
		sb.getTeam(playerRanks.get(uuid).getName()).addEntry(player.getName());
		
	}
	

	public void deletePlayer(Player player) {
		String uuid = player.getPlayer().getUniqueId().toString();
		if(!playerRanks.containsKey(uuid)) return;
		playerRanks.remove(uuid);
	}
	
	public RankList getPlayerRank(Player player) {
		String uuid = player.getPlayer().getUniqueId().toString();
		if(playerRanks.containsKey(uuid)) loadPlayer(player);
		return playerRanks.get(uuid);
	}

	public RankList getRankById(int id) {
		for(RankList rankL : RankList.values()) {
			if(rankL.getId() == id) return rankL;
		}
		return RankList.JOUEUR;
	}
	
	private void saveConfig() {
		try {
			config.save(file);
		} catch(IOException error) {error.printStackTrace();} 
	}
}
