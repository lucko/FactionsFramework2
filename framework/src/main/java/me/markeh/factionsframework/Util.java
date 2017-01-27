package me.markeh.factionsframework;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Util {

	private static final Map<ChatColor, Pattern> colors;
	static {
		colors = new HashMap<>();
		for (ChatColor color : ChatColor.values()) {
			colors.put(color, Pattern.compile("<" + color.name().toLowerCase() + ">"));
		}
	}

	private Util() {}

	public static String colourse(String msg) {
		for (Map.Entry<ChatColor, Pattern> e : colors.entrySet()) {
			msg = e.getValue().matcher(msg).replaceAll("" + e.getKey());
		}
		
		return msg;
	}
	
}
