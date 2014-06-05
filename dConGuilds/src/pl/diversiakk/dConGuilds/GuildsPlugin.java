package pl.diversiakk.dConGuilds;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;




public class GuildsPlugin extends JavaPlugin implements Listener{
	
	
    private static Connection connection;
    
	public boolean running;
	protected static GuildsPlugin plugin;
	
	
	
	
	
	
	public void onEnable() {
	    plugin = this;
	    this.running = true;
	    new PlayerListener(this);
	    Manager.init(this);
	    Manager.loadSettings();
		System.out.println("   ++++++++++++++   ");
		System.out.println("  ================  ");
		System.out.println(" ================== ");
		System.out.println("====================");
		System.out.println("    D I V E R S E    ");
		System.out.println("====================");
		System.out.println(" ================== ");
		System.out.println("  ================  ");
		System.out.println("   ++++++++++++++   ");
		System.out.println(Manager.getMsgPerms());
		if(Manager.getDbHost().equals(null)) {
			System.out.println("[MYSQL] Hostname field is empty! Please check your config! Dying...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}else {
			System.out.println("[MYSQL] Hostname field is correct! Preparing to connect. [1/5]");
		}
		if(Manager.getDbUser().equals(null)) {
			System.out.println("[MYSQL] Username field is empty! Please check your config! Dying...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}else {
			System.out.println("[MYSQL] Username field is correct! Preparing to connect. [2/5]");
		}
		if(Manager.getDbPass().equals(null)) {
			System.out.println("[MYSQL] Password field is empty! Please check your config! Dying...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}else {
			System.out.println("[MYSQL] Password field is correct! Preparing to connect. [3/5]");
		}
		if(Manager.getDbPort().equals(null)) {
			System.out.println("[MYSQL] Port field is empty! Please check your config! Dying...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}else {
			System.out.println("[MYSQL] Port field is correct! Preparing to connect. [4/5]");
		}
		if(Manager.getDbName().equals(null)) {
			System.out.println("[MYSQL] Database Name field is empty! Please check your config! Dying...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}else {
			System.out.println("[MYSQL] Database Name field is correct! Preparing to connect. [5/5]");
		}
		
	}
	
	public void OnDisable() {
		try {
			if(connection == null || !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static boolean playerDataContainsPlayer (Player player) {
		
		try {
			PreparedStatement sql = connection.prepareStatement("SELECT * FROM statystyki WHERE Nick = '" + player.getName() +"'");
			ResultSet resultSet = sql.executeQuery();
			boolean containsPlayer = resultSet.next();
			sql.close();
			resultSet.close();
			return containsPlayer;
		
	}catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Table Bany not exists!");
		return false;
	}
	}
	
	public void openConnection() {
		try{
			
			System.out.println("[MYSQL] Config is correctly! Connecting...");
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + Manager.getDbHost() + ":" + Manager.getDbPort() + "/"+ Manager.getDbName(),  Manager.getDbUser(), Manager.getDbUser());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Cannot connect to database! Disabling...");
			getServer().getPluginManager().disablePlugin(this);
			
		}
	}
	
	public synchronized static void closeConnection() {
		try{
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
}
