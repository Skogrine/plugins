package fr.skogrin.medievaltown.panelmoderation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.skogrin.medievaltown.panelmoderation.commands.Commands;
import fr.skogrin.medievaltown.panelmoderation.listeners.ModItemsInteract;
import fr.skogrin.medievaltown.panelmoderation.listeners.PlayerChat;
import fr.skogrin.medievaltown.panelmoderation.listeners.PlayerQuit;
import fr.skogrin.medievaltown.panelmoderation.listeners.ReportEvent;
import fr.skogrin.medievaltown.panelmoderation.manager.PlayerManager;
import fr.skogrin.medievaltown.panelmoderation.utils.ModCancels;

public class Main extends JavaPlugin {
    private static Main instance;
 
 
    private List<UUID> moderateurs;
    private Map<UUID, PlayerManager> players;
    private Map<UUID, Location> frozenPlayers;
 
    @Override
    public void onEnable() {
        setup();
    }
 
    public static Main getInstance() {
        return instance;
    }
 
 
    private void setup(){
        instance = this;
        registerEvents();
        registerCommands();
        moderateurs = new ArrayList<>();
        players = new HashMap<>();
        frozenPlayers = new HashMap<>();
    }
 
    private void registerEvents(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ReportEvent(), this);
        pm.registerEvents(new ModCancels(), this);
        pm.registerEvents(new ModItemsInteract(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerQuit(), this);
    }
 
    private void registerCommands(){
        getCommand("mod").setExecutor(new Commands());
        getCommand("report").setExecutor(new Commands());
    }
 
    public List<UUID> getModerateurs() {
        return moderateurs;
    }
 
    public Map<UUID, PlayerManager> getPlayers() {
        return players;
    }
 
    public Map<UUID, Location> getFrozenPlayers() {
        return frozenPlayers;
    }
 
    public boolean isFreeze(Player player){
        return getFrozenPlayers().containsKey(player.getUniqueId());
    }
}