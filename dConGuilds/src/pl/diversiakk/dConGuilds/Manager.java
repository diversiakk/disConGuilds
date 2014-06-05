package pl.diversiakk.dConGuilds;

import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Manager
{
  private static HashMap<String, String> paths = new HashMap();
  private static GuildsPlugin plugin;
  private static FileConfiguration config = null;
  
 /** MYSQL CONFIG CONNECTION **/
  
  public static String getDbHost()
  {
    return dbHost;
  }
  
  private static String dbHost = null;
  
  public static String getDbUser()
  {
    return dbUser;
  }
  
  private static String dbUser = null;
  
  public static String getDbPass()
  {
    return dbPass;
  }
  
  private static String dbPass = null;
  
  public static String getDbPort()
  {
    return dbPort;
  }
  
  private static String dbPort = null;
  
  public static String getDbName()
  {
    return dbName;
  }
  
  private static String dbName = null;
  
  /** MYSQL CONFIG CONNECTION **/
  
  public static String getMsgPerms()
  {
    return msgPerms;
  }
  
  private static String msgPerms = null;
  
  public static void init(GuildsPlugin plug)
  {
    plugin = plug;
    plugin.saveDefaultConfig();
    config = plugin.getConfig();
    paths.put("dbHost", "MySQL.Host");
    paths.put("dbUser", "MySQL.User");
    paths.put("dbPass", "MySQL.Password");
    paths.put("dbPort", "MySQL.Port");
    paths.put("dbName", "MySQL.DatabaseName");
    paths.put("msgPerms", "Messages.Permissions");
  }
  
  public static void loadSettings()
  {
    dbHost = config.getString((String)paths.get("dbHost"));
    dbUser = config.getString((String)paths.get("dbUser"));
    dbPass = config.getString((String)paths.get("dbPass"));
    dbPort = config.getString((String)paths.get("dbPort"));
    dbName = config.getString((String)paths.get("dbName"));
    msgPerms = config.getString((String)paths.get("msgPerms"));
  }
  
  
  public static void saveConfig()
  {
    plugin.saveConfig();
  }
  
  public static String colorize(String s)
  {
    if (s == null) {
      return null;
    }
    return s.replaceAll("&([0-9a-f])", "§$1");
  }
  
  public static void setOption(String setting, Object value) {}
}
