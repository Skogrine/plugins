package fr.directelk.profil.bukkit.commands;

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


public class Commands implements CommandExecutor {
	



	Inventory profil;

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		Player player = (Player) sender;
		String invName = ChatColor.DARK_RED + "Profil de " + ChatColor.BLUE + player.getName();
		profil = Bukkit.createInventory(null, 9, invName);
		player.openInventory(profil);
		
		
		ArrayList<String> p1Lore = new ArrayList<String>();
		p1Lore.add("§6Pseudo : §f" + player.getName());
		p1Lore.add("§6Grade : §c Non disponible");
		p1Lore.add("§6Booster : §f" + "§4§lIndisponible" );
		ItemStack p = CreateItem(Material.SKULL_ITEM, "§a§lInformation de votre profil", p1Lore);
		profil.setItem(0, p);
		
		ArrayList<String> rLore = new ArrayList<String>();
		
		ItemStack r = CreateItem(Material.BARRIER, "§cRetour au menu", rLore);
		profil.setItem(8, r);

		
		
		return true;
	}
	
	
	
	private ItemStack CreateItem(Material mat, String name, ArrayList<String> lore) {
		ItemStack p = new ItemStack(mat, 1);
		ItemMeta p1 = p.getItemMeta();
		
		p1.setDisplayName(name);
		p1.setLore(lore);
		
		p.setItemMeta(p1);
		
		return p;
	}




}
