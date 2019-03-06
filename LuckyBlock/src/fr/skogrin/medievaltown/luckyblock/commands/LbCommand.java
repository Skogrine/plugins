package fr.skogrin.medievaltown.luckyblock.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class LbCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("Seul le joueur peut executer cette commande");
			return false;
		}
		Player p = (Player) sender;

		if (label.equalsIgnoreCase("lb")) {
			if (args.length == 0) {
				p.sendMessage("§b[MédiévalTown] §cVeuillez préciser le joueur et le nombre");
				p.sendMessage("§b[MédiévalTown] §cUtilisation correct : /lb give (player) (nombre)");
			}
			if (args[0] == "give") {

				ItemStack LuckyBlock = new ItemStack(Material.SKULL_ITEM, 10, (byte) 3);
				SkullMeta lbM = (SkullMeta) LuckyBlock.getItemMeta();
				lbM.setOwner("luck");
				lbM.setDisplayName("§6§lLuckyBlock");
				LuckyBlock.setItemMeta(lbM);

				p.getInventory().setItem(2, LuckyBlock);

			}
		}

		return false;
	}

}
