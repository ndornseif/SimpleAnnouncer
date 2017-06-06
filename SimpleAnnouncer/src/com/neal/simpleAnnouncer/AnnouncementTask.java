package com.neal.simpleAnnouncer;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AnnouncementTask extends BukkitRunnable {

    private final JavaPlugin plugin;
	private final String message;

    public AnnouncementTask(JavaPlugin pPlugin,String pMessage) {
        this.plugin = pPlugin;
        this.message = pMessage;
    }

    @Override
    public void run() {

        plugin.getServer().broadcastMessage(replaceColors(plugin.getConfig().getString("prefix"))+replaceColors(message));
    }
    
    public static String replaceColors(String string){
    	return string.replaceAll("(?i)&([a-k0-9])", "\u00A7$1");
    	}

}