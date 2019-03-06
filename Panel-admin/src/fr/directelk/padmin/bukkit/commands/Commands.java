package fr.directelk.padmin.bukkit.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements CommandExecutor{
	
	Inventory pAdmin;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		System.out.println("Une commande vient de s'executer !");
		if (!(sender instanceof Player)) {
			try {
				throw new Exception("L'expéditeur doit être une instance de joueur.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
			
		Player player = (Player) sender;
		String invName = ChatColor.DARK_RED + "------Panel" + ChatColor.DARK_BLUE + " Admin------";
		pAdmin = Bukkit.createInventory(null, 9, invName);
		player.openInventory(pAdmin);
		
		ArrayList<String> stopLore = new ArrayList<String>();
		stopLore.add("§6§lEn cliquant sur cette barrière,");
		stopLore.add("§6§lVous allez fermé le serveur !");
		ItemStack stop = CreateItem(Material.BARRIER, "§4§lStop le serveur", stopLore);
		pAdmin.setItem(0, stop);
		
		ArrayList<String> reloadLore = new ArrayList<String>();
		reloadLore.add("§a§lEn cliquant sur cette torche,");
		reloadLore.add("§a§lVous allez Reload le serveur !");
		ItemStack reload = CreateItem(Material.RED_ROSE, "§a§lReload Le serveur", reloadLore);
		pAdmin.setItem(2, reload);
		
		ArrayList<String> restartLore = new ArrayList<String>();
		restartLore.add("§a§lEn cliquant sur cette torche,");
		restartLore.add("§a§lVous allez Restart le serveur !");
		ItemStack restart = CreateItem(Material.REDSTONE_LAMP_OFF, "§a§lRestart Le serveur", restartLore);
		pAdmin.setItem(3, restart);
		
		ArrayList<String> BCLore = new ArrayList<String>();
		BCLore.add("§6§lEn cliquant sur ce panneau,");
		BCLore.add("§6§lVous allez pourvoir écrire un message BC !");
		ItemStack BC = CreateItem(Material.SIGN, "§c§lMassage sur le serveur", BCLore);
		pAdmin.setItem(1, BC);
		
		ArrayList<String> statLore = new ArrayList<String>();
		statLore.add("§6Item d'information,");
		statLore.add("§6Status : ");
		ItemStack stat = CreateItem(Material.CARROT, "§c§lStatut sur le serveur", statLore);
		pAdmin.setItem(8, stat);
		
		
		
		return true;
	}
	

	private ItemStack CreateItem(Material mat, String name, ArrayList<String> lore) {
		ItemStack stop = new ItemStack(mat, 1);
		ItemMeta stopM = stop.getItemMeta();
		
		stopM.setDisplayName(name);
		stopM.setLore(lore);
		
		stop.setItemMeta(stopM);
		
		return stop;
	}

	
}
