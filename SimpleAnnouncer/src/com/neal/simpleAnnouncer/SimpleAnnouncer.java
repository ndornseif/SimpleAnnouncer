package com.neal.simpleAnnouncer;

import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleAnnouncer  extends JavaPlugin{
	FileConfiguration config = getConfig();
	
	 @SuppressWarnings("serial")
	 @Override
	 public void onEnable() {
		 //If the plugin is supposed to be active
		 config.addDefault("active", true);
		 
		 //If the messages are send in a random order
		 config.addDefault("random", false);
		 
		 config.addDefault("prefix", "[Announcement] ");
		 
		 //Interval for sending messages (in Seconds)
		 config.addDefault("interval", 50);
		 
		 config.addDefault("announcements", new ArrayList<String>(){{
		 add("&amessage1");
		 add("&bmessage2");
		 add("&cmessage3");
		 }});
		 
		 config.options().copyDefaults(true);
	     config.options().header("SimpleAnnouncer");
		 saveConfig();

		 getLogger().info("Plugin enabled");
		 if(this.getConfig().getBoolean("active")){
			 new AsyncAnnouncerTask(this).runTaskTimerAsynchronously(this, 200, (this.getConfig().getInt("interval")*20));
		 }
	 }
	 
	@Override
	public void onDisable() {
		getLogger().info("Plugin disabled");
	}
	 

}
