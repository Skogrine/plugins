package fr.skogrin.medievaltown.rank;

public enum RankList {

	/*
	 * Model du tchat 
	 * 
	 * [Admin] (pseudo) (suffix) (ChatSeparator) (message)
	 */
	
	ADMIN(13, 100, "§c[Admin] ", "", " §f➢ "),
	RESP(12, 50, "§6[Resp] ", "", " §f➢ "),
	SUPMODO(11, 30, "§1[Sup-Modo] ", "", " §f➢ "),
	MODO(10, 20, "§9[Modérateur] ", "", " §f➢ "),
	MODOT(9, 10, "§b[Modo-Tchat] ", "", " §f➢ "),
	BUILDER(8, 5, "§a[Builder] ", "", " §f➢ "),
	DEV(7, 5, "§d[Dev] ", "", " §f➢"),
	PART(6, 4, "§e[Partenaire] ", "", " §f➢ "),
	MVIP(5, 3, "§3[MégaVIP] ", "", " §f>> "),
	UVIP(4, 2, "§2[UltraVIP] ", "", " §f>> "),
	VIP2(3, 1, "§a[VIP+] ", "", " §f> "),
	VIP(2, 1, "§a[VIP] ", "", " §f> "),
	JOUEUR(1, 1, "§7", "", " §7> ");
	
	//Fields
	private final int id, power;
	private final String prefix, suffix, chatSeparator;
	
	//Constructor
	private RankList(int id, int power, String prefix, String suffix, String chatSeparator) {
		this.id = id;
		this.power = power;
		this.prefix = prefix;
		this.suffix = suffix;
		this.chatSeparator = chatSeparator;
	}
	
	//Methode GETTER
	public final int getId() {
		return id;
	}
	
	public int getPower() {
		return power;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public String getChatSeparator() {
		return chatSeparator;
	}
	
	public String getName() {
		return this.toString();
	}
}
