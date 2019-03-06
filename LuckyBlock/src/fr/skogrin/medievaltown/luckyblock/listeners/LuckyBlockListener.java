package fr.skogrin.medievaltown.luckyblock.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.skogrin.medievaltown.luckyblock.Main;
import net.minecraft.server.v1_8_R3.Items;

public class LuckyBlockListener implements Listener {

	private Main main;

	public LuckyBlockListener(Main main2) {
		this.main = main2;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent pje) {

		Player player = pje.getPlayer();

		player.getInventory().clear();

		// --------------BOUSSOLE BUNGEE---------------
		ItemStack chooseServer = new ItemStack(Material.COMPASS, 1);
		ItemMeta csIM = chooseServer.getItemMeta();
		csIM.setDisplayName("§bChoix du Serveur !");
		csIM.addEnchant(Enchantment.DURABILITY, 999, true);
		csIM.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		chooseServer.setItemMeta(csIM);
		// --------------MENU DES JEUX-------------
		ItemStack chooseGames = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta cgIM = chooseGames.getItemMeta();
		cgIM.setDisplayName("§aChoix des jeux !");
		cgIM.addEnchant(Enchantment.DURABILITY, 999, true);
		cgIM.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		chooseGames.setItemMeta(cgIM);
		// --------------BOUTIQUE-------------
		ItemStack shop = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta shopM = chooseGames.getItemMeta();
		shopM.setDisplayName("§6§lBoutique !");
		shopM.addEnchant(Enchantment.DURABILITY, 999, true);
		shopM.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		shop.setItemMeta(shopM);

		// ---------------------------------------------------------------------
		ItemStack coins = new ItemStack(Material.IRON_INGOT, 1);
		ItemMeta coinsM = chooseGames.getItemMeta();
		coinsM.setDisplayName("§6Coins");
		coins.setItemMeta(coinsM);
		// ---------------------------------------------------------------------

		ItemStack LuckyBlock = new ItemStack(Material.SKULL_ITEM, 10, (byte) 3);
		SkullMeta lbM = (SkullMeta) LuckyBlock.getItemMeta();
		lbM.setOwner("luck");
		lbM.setDisplayName("§6§lLuckyBlock");
		LuckyBlock.setItemMeta(lbM);

		// --------------MISE EN PLACE DES ITEM DANS L'INVENTAIRE--------------
		player.getInventory().setItem(0, chooseServer);
		player.getInventory().setItem(4, chooseGames);
		player.getInventory().setItem(8, shop);
		player.getInventory().setItem(7, LuckyBlock);

		player.updateInventory();
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();

		BlockState bs = block.getState();

		if (bs instanceof Skull) {
			Skull skull = (Skull) bs;
			if (skull.getOwner().equalsIgnoreCase("luck")) {
				event.setCancelled(true);
				block.setType(Material.AIR);

				Random random = new Random();
				int alea = random.nextInt(4);

				switch (alea) {
				case 0:
					player.sendMessage("§6[LuckyBlock] §cQuelle poisse !");
					break;
				case 1:
					player.sendMessage("§6[LuckyBlock] §bDes feux D'artifice ! OUIIII !");
					block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.FIREWORK, 3));
					break;
				case 2:
					player.sendMessage("§6[LuckyBlock] §aTien un petit ligot de fer :) !");
					block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.IRON_INGOT, 1));
					break;
				case 3:
					player.sendMessage("§6[LuckyBlock] §aTu as faim ? non ? dommage !");
					block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CARROT, 5));
					break;
				}
			}

		}

	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		Action action = e.getAction();
		ItemStack is = e.getItem();

		if (is == null)
			return;

		if (is.getType() == Material.COMPASS && is.hasItemMeta() && is.getItemMeta().hasDisplayName()
				&& is.getItemMeta().getDisplayName().equalsIgnoreCase("§bChoix du Serveur !")) {

			Inventory Server = Bukkit.createInventory(null, 27, "§cChoix du Serveur !");
			Inventory ServerChoose = Bukkit.createInventory(null, 27, "§cChoix du Serveur !");

			// ----------------| SERVEUR CHOOSE |----------------------------

			ItemStack lobby = new ItemStack(Material.COMPASS, 1);
			ItemMeta lobbyM = lobby.getItemMeta();
			lobbyM.setDisplayName("§aLobby01");
			lobbyM.addEnchant(Enchantment.DURABILITY, 999, true);
			lobbyM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			lobby.setItemMeta(lobbyM);

			ItemStack lobby2 = new ItemStack(Material.COMPASS, 1);
			ItemMeta lobby2M = lobby2.getItemMeta();
			lobby2M.setDisplayName("§aLobby02");
			lobby2.setItemMeta(lobby2M);

			ItemStack lobby3 = new ItemStack(Material.COMPASS, 1);
			ItemMeta lobby3M = lobby3.getItemMeta();
			lobby3M.setDisplayName("§aLobby03");
			lobby3.setItemMeta(lobby3M);

			// -------------| MENU SERVER |-------------------

			ItemStack ChooseLobby = new ItemStack(Material.COMPASS, 1);
			ItemMeta ChooseLobbyM = ChooseLobby.getItemMeta();
			ChooseLobbyM.setDisplayName("§e§lChanger de Lobby");
			ChooseLobbyM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS,
					ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE);
			ChooseLobby.setItemMeta(ChooseLobbyM);
			// -------------| APPLICATION DES ITEM DANS L'INVENTAIRE |-------------------

			Server.setItem(1, ChooseLobby);

			ServerChoose.setItem(10, lobby);
			ServerChoose.setItem(11, lobby2);
			ServerChoose.setItem(12, lobby3);

			p.openInventory(Server);
		}

	}

	@EventHandler
	public void onDisconnect(PlayerQuitEvent pqe) {
		Player player = pqe.getPlayer();
		player.getInventory().clear();
	}

}
