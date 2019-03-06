package fr.skogrin.medievaltown.vote.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.skogrin.medievaltown.vote.utils.ItemBuilder;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peut executer cette commande !");
            return false;
        }
		
		Player player = (Player) sender;
		 
        if(label.equalsIgnoreCase("vote")){
            Inventory inv = Bukkit.createInventory(null, 18, "§aVote: §c" + player.getName());
 
            inv.setItem(0, new ItemBuilder(Material.IRON_SWORD).setName("§aServeurs-minecraft").setLore("§bVote sur Serveurs-Minecraft pour recevoir une récompense").toItemStack());
            inv.setItem(1, new ItemBuilder(Material.FEATHER).setName("§aTopg").toItemStack());
            inv.setItem(17, new ItemBuilder(Material.BARRIER).setName("§cRetour").toItemStack());
            player.openInventory(inv);
        }
        
		return false;
	}

}
