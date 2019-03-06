package fr.skogrin.medievaltown.rank.bukkit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.skogrin.medievaltown.rank.Rank;



public class RankCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		private final Rank rank;
		
		if (!(sender instanceof Player)) {
			try {
				throw new Exception("L'expediteur doit etre une instance de joueur.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Player p = (Player) sender;
		
		if(label.equalsIgnoreCase("rank")){
			if(!p.hasPermission("rank.admin")){
                p.sendMessage("§b[MédiévalTown] §cVous n'avez pas la permission d'éxecuter cette commande !");
                return false;
            }
			if(args.length == 1) {

				p.sendMessage("§b[MédiévalTown] §cVous devez saisir le pseudo du joueur et son grade !");
			}
			if(args.length >= 1) {
				Player cible = Bukkit.getPlayer(args[0]);
				if(cible != null){ 
                	String grade = String.valueOf(args[1]);
                	rank.changePlayer(p);
				}
			}
		
		
			return false;
		}


	}
}
