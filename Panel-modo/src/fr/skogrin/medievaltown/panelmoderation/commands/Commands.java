package fr.skogrin.medievaltown.panelmoderation.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.skogrin.medievaltown.panelmoderation.manager.PlayerManager;
import fr.skogrin.medievaltown.panelmoderation.utils.ItemBuilder;

public class Commands implements CommandExecutor {
	 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peut executer cette commande !");
            return false;
        }
 
        Player player = (Player) sender;
 
        if(label.equalsIgnoreCase("mod")){
            if(!player.hasPermission("moderation.mod")){
                player.sendMessage("§b[MédiévalTown] §cVous n'avez pas la permission d'éxecuter cette commande !");
                return false;
            }
 
            if(PlayerManager.isInModerationMod(player)){
                PlayerManager.getFromPlayer(player).destroy();
            } else {
                new PlayerManager(player).init();
            }
        }
 
        if(label.equalsIgnoreCase("report")){
            if(args.length != 1){
                player.sendMessage("§b[MédiévalTown] §cVeuillez saisir le pseudo d'un joueur !");
                return false;
            }
 
            String targetName = args[0];
 
            if(Bukkit.getPlayer(targetName) == null){
                player.sendMessage("§b[MédiévalTown] §cCe joueur n'est pas connecté ou n'existe pas !");
                return false;
            }
 
            Player target = Bukkit.getPlayer(targetName);
 
            Inventory inv = Bukkit.createInventory(null, 18, "§aReport: §c" + target.getName());
 
            inv.setItem(0, new ItemBuilder(Material.IRON_SWORD).setName("§cForceField").toItemStack());
            inv.setItem(1, new ItemBuilder(Material.BOW).setName("§cSpamBow").toItemStack());
            inv.setItem(2, new ItemBuilder(Material.BARRIER).setName("§cHACK").toItemStack());
            inv.setItem(3, new ItemBuilder(Material.FEATHER).setName("§cFly").toItemStack());
 
            player.openInventory(inv);
        }
 
        return false;
    }
}