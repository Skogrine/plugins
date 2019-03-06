package fr.skogrin.medievaltown.panelmoderation.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.skogrin.medievaltown.panelmoderation.Main;
 

public class BanCommand implements CommandExecutor {
 
    private Main plugin;

    public BanCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("ban").setExecutor(this);
    }
 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if (label.equalsIgnoreCase("ban")) {
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
 
                String banner = "Server";
 
                if (sender instanceof Player) {
                    banner = sender.getName();
                }

                target.kickPlayer(ChatColor.DARK_RED+"§b[MédiévalTown]\n"+ChatColor.RED+"Vous avez été ban de MédiévalTown!\nPar: "+banner+"\nRaison: "+x.toString().trim());
                plugin.getConfig().set("banned_players."+target.getName()+".Modérateur", banner);
                plugin.getConfig().set("banned_players."+target.getName()+".Raison", x.toString().trim());
                plugin.saveConfig();
 

                sender.sendMessage(ChatColor.GREEN+"Joueur bannie avec :"+ChatColor.GREEN+" SUCCES "+target.getName());
            }
        }
 
        return true;
    }
}
