package com.neal.simpleAnnouncer;

import java.util.List;
import java.util.Random;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AsyncAnnouncerTask extends BukkitRunnable {

    private final JavaPlugin plugin;
    private int messageCounter;
    private Random randomGenerator;

    
    public AsyncAnnouncerTask(JavaPlugin pPlugin) {
        this.plugin = pPlugin;
        this.randomGenerator = new Random();
        
    }

    @Override
    public void run() {
    	messageCounter++;
    	if(!(messageCounter<plugin.getConfig().getStringList("announcements").size())){
    		messageCounter = 0;
    	}
		List<String> anouncementList = plugin.getConfig().getStringList("announcements");

    	if(plugin.getConfig().getBoolean("random")){
    		
    		new AnnouncementTask(plugin, anouncementList.get(randomGenerator.nextInt(anouncementList.size()))).runTask(this.plugin);
    	}else{
    		new AnnouncementTask(plugin, anouncementList.get(messageCounter)).runTask(this.plugin);
    	}
    }

}