package fr.skogrin.medievaltown.panelmoderation.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommands implements CommandExecutor {
 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("kick")) {
            if (args.length == 0) {
                sender.sendMessage("§b[MédiévalTown] §cVeuillez préciser un joueur et une raison !");
            } else if (args.length == 1) {
                sender.sendMessage("§b[MédiévalTown] &cVeuillez préciser une raison !");
            } else {
                Player target = Bukkit.getPlayer(args[0]);
 
                if (target == null) {
                    sender.sendMessage("§b[MédiévalTown]" +ChatColor.RED+args[0]+" N'est pas en ligne!");
                    return true;
                }
 
                StringBuilder x = new StringBuilder();
 
                for (int i = 1; i < args.length; i++) {
                    x.append(args[i]+" ");
                }
 
                String kicker = "Server";
 
                if (sender instanceof Player) {
                    kicker = sender.getName();
                }
 
                target.kickPlayer(ChatColor.RED+"Vous avez été Kick de" + ChatColor.AQUA+"MédiévalTown!"+ChatColor.RED
                		+"\nPar: "+kicker+"\nReason: "+x.toString().trim());
                sender.sendMessage("§b[MédiévalTown]" +ChatColor.GREEN+"Le joueur a été kick: "+target.getName());
            }
 
 
        }
 
        return true;
    }
}