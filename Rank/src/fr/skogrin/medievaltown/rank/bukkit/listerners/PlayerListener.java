package fr.skogrin.medievaltown.rank.bukkit.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.skogrin.medievaltown.rank.Rank;
import fr.skogrin.medievaltown.rank.RankList;

public final class PlayerListener implements Listener{

	private final Rank rank;
	
	public PlayerListener(Rank rank) {
		this.rank = rank;
	}
	
	@EventHandler
	private void playerJoin(PlayerJoinEvent pje) {
		rank.loadPlayer(pje.getPlayer());
		pje.getPlayer().setScoreboard(rank.getSb());
	}
	
	@EventHandler
	private void playerQuit(PlayerQuitEvent pqe) {
		rank.deletePlayer(pqe.getPlayer());
	}
	
	@EventHandler
	private void playerChat(AsyncPlayerChatEvent pce) {
		RankList rankL = rank.getPlayerRank(pce.getPlayer());
		pce.setFormat(rankL.getPrefix()+pce.getPlayer().getName()+rankL.getSuffix()+rankL.getChatSeparator()+pce.getMessage());
	}
	
	
}
