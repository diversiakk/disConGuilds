package pl.diversiakk.dConGuilds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	 private GuildsPlugin plugin;
	 String header = "&f=&C<>&f=&C<>&f=&C<>&f=&C<>&f=\n";
	
	  public PlayerListener(GuildsPlugin plugin)
	  {
	    this.plugin = plugin;
	    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	    
	  }
	  
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onPlayerPreLogin(PlayerJoinEvent e) 
	  {
		  
		  Player p = e.getPlayer();
	  }
	  
}


