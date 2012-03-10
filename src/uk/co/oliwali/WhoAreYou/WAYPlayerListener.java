package uk.co.oliwali.WhoAreYou;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class WAYPlayerListener implements Listener {
	
	public WhoAreYou plugin;

	public WAYPlayerListener(WhoAreYou instance) {
		plugin = instance;
	}
	
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (plugin.config.onlineMsg)
			plugin.who(event.getPlayer());
	}
	
}