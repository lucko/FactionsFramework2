package me.markeh.factionsframework;

import me.markeh.factionsframework.enums.FactionsVersion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class LogUtil {

	private LogUtil() {}
	
	// -------------------------------------------------- //
	// FIELDS
	// -------------------------------------------------- //

	private static final ChatColor COLOR = ChatColor.AQUA;
	private static final ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();
	private static final String PLUGIN_NAME = "FactionsFramework";
	
	// -------------------------------------------------- //
	// METHODS
	// -------------------------------------------------- //
	
	public static String getPluginName() {
		return PLUGIN_NAME;
	}
	
	public static ChatColor getColour() {
		return COLOR;
	}
	
	public static ConsoleCommandSender getConsole() {
		return CONSOLE;
	}
	
	public static void log(String msg) {
		CONSOLE.sendMessage(COLOR + "[" + PLUGIN_NAME + "] " + ChatColor.WHITE + msg);
	}
	
	public static void err(Exception e) {
		CONSOLE.sendMessage(
				ChatColor.RED + "[" + PLUGIN_NAME + "] " +
				ChatColor.MAGIC + "!!" + ChatColor.RESET + ChatColor.RED + "ERROR" + ChatColor.MAGIC + "!!" + ChatColor.RESET + 
				ChatColor.GOLD + " An internal error occured! " + e.toString());
		
		e.printStackTrace();
		
		Throwable cause = null;
		cause = e.getCause();
		
		while (cause != null) {
			CONSOLE.sendMessage(ChatColor.GOLD + "caused by " + cause.getMessage());
			cause.printStackTrace();
			cause = cause.getCause();
		}
		
		String factionsVersion = FactionsVersion.get().name();
		String frameworkVersion = FactionsFramework.VERSION;
		String serverVersion = Bukkit.getVersion();
		
		CONSOLE.sendMessage(ChatColor.GOLD + "version_info: factionsversion=" + factionsVersion + ",frameworkversion=" + frameworkVersion + ",serverversion=" + serverVersion + "//");
	}
	
}
