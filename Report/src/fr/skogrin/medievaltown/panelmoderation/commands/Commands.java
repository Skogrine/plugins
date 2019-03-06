package fr.skogrin.medievaltown.panelmoderation.commands;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.skogrin.medievaltown.panelmoderation.manager.PlayerManager;
import fr.skogrin.medievaltown.panelmoderation.mysql.MysqlConnector;

public class Commands implements CommandExecutor {
	
	private MysqlConnector sql;
	
	public Commands(MysqlConnector sql) {
		this.sql = sql;
	}
	 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peut executer cette commande !");
            return false;
        }
 
        Player p = (Player) sender;
 
        if(label.equalsIgnoreCase("mod")){
            if(!p.hasPermission("moderation.mod")){
                p.sendMessage("§b[MédiévalTown] §cVous n'avez pas la permission d'éxecuter cette commande !");
                return false;
            }
 
            if(PlayerManager.isInModerationMod(p)){
                PlayerManager.getFromPlayer(p).destroy();
            } else {
                new PlayerManager(p).init();
            }
        }
 
        // /report (player) (reason)
        
        if(label.equalsIgnoreCase("report")){
            if(args.length != 0){
                p.sendMessage("§b[MédiévalTown] §cVeuillez saisir le pseudo d'un joueur !");
                p.sendMessage("§b[MédiévalTown] §c/report (Joueur) (raison)");
                return false;
            }
            if(args.length != 1) {
            	p.sendMessage("§b[MédiévalTown] §cVeuillez entrer une raison !");
            	p.sendMessage("§b[MédiévalTown] §c/report (Joueur) (raison)");
            	return false;
            }
            if(args.length >= 1) {
            	Player cible = Bukkit.getPlayer(args[0]);
                if(cible != null){ 
                	String reason = String.valueOf(args[1]);
                	sql.addReport(cible, reason);
                	p.sendMessage("§b[MédiévalTown] §aVotre report a été envoyé !");
                	try {
						p.sendMessage("Vous avez actuellement " + sql.getReport(cible) + "en cours de traitement !");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	System.out.println(p.getName() + "a envoyé un report !");
                	return true;
                }
            }
        }
 
        return false;
    }
}