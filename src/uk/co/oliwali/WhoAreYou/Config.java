package uk.co.oliwali.WhoAreYou;

import java.util.HashMap;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	
	private HashMap<String, String> aliases = new HashMap<String, String>();
	public WhoAreYou plugin;
	private FileConfiguration config;
	public boolean onlineMsg;

	public Config (WhoAreYou instance) {
		
		this.plugin = instance;
		this.config = plugin.getConfig();
		
		//If there are no aliases yet
		if (config.getConfigurationSection("aliases") == null) {
			World[] worlds = (World[]) plugin.getServer().getWorlds().toArray(new World[0]);
			for (World world : worlds)
				config.set("aliases." + world.getName(), world.getName());
		}
		
		//Message players on join
		if (config.get("msg-online-on-join") == null)
			config.set("msg-online-on-join", true);
		
		//Load aliasess into hashmap
		String[] worlds = (String[]) config.getConfigurationSection("aliases").getKeys(false).toArray(new String[0]);
		for (String world : worlds)
			aliases.put(world, config.getString("aliases." + world));
		
		onlineMsg = config.getBoolean("msg-online-on-join", true);
		
		//save
		plugin.saveConfig();

	}
	
	public String getAliasFromWorld(World world) {
		return aliases.get(world.getName());
	}
	
}