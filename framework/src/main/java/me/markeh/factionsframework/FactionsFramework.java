/**
 * Factions Framework-  Way too much caffeine was required to make this.
 * Copyright (C) 2016  Mark Hughes ("MarkehMe") <m@rkhugh.es>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * https://github.com/MarkehMe/FactionsFramework
 *
 */

package me.markeh.factionsframework;

import me.markeh.factionsframework.command.FactionsCommandManager;
import me.markeh.factionsframework.deprecation.Deprecation;
import me.markeh.factionsframework.entities.FPlayers;
import me.markeh.factionsframework.entities.Factions;
import me.markeh.factionsframework.enums.FactionsVersion;
import me.markeh.factionsframework.layer.ConfLayer;
import me.markeh.factionsframework.layer.EventsLayer;
import me.markeh.factionsframework.layer.LoadBase;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

/**
 * Factions Framework has a 6 month deprecation policy.
 * See me.markeh.factionsframework.deprecation.Deprecation for information.
 */
public class FactionsFramework {
	// -------------------------------------------------- //
	// SINGLETON
	// -------------------------------------------------- //

	public static final String VERSION = "1.2.0";
	private static FactionsFramework instance;

	public static FactionsFramework get() {
		return instance;
	}

	public static boolean isLoaded() {
		return instance != null;
	}

	public static void load(Plugin plugin) {
		if (isLoaded()) {
			throw new IllegalStateException("Already loaded");
		}

		instance = new FactionsFramework(plugin);
	}

	// -------------------------------------------------- //
	// INSTANCE
	// -------------------------------------------------- //

	private final Plugin loadedBy;

	private FactionsFramework(Plugin plugin) {
		this.loadedBy = plugin;

		// Initialise ConfLayer early
		ConfLayer.get();

		// Enable events
		Bukkit.getPluginManager().registerEvents(EventsLayer.get(), plugin);

		LogUtil.log("Factions API version is: " + FactionsVersion.get().toString());

		if (LoadBase.get() != null) {
			LoadBase.get().enabled();
		}
	}

	public void stop() {
		instance = null;

		// Unregister our events layer
		HandlerList.unregisterAll(EventsLayer.get());

		FactionsCommandManager.get().removeAll();

		if (LoadBase.get() != null) {
			LoadBase.get().disabled();
		}
	}
	
	public final void err(Exception e) {
		LogUtil.err(e);
	}
	
	public final void log(String...msgs) {
		for (String msg : msgs) LogUtil.log(msg);
	}

	public final Plugin getLoadedBy() {
		return this.loadedBy;
	}
	
	/**
	 * Get Factions instance 
	 * 
	 * @deprecated to be removed on 06/12/2016
	 * Use the static methods instead of this instance
	 */
	@Deprecated
	public final Factions getFactions() {
		Deprecation.showDeprecationWarningForMethod("FactionsFramework#getFactions");
		return ((Factions) Factions.getHandler());
	}
	
	/**
	 * Get FPlayers instance 
	 * 
	 * @deprecated to be removed on 06/12/2016
	 * Use the static methods instead of this instance
	 */
	@Deprecated
	public final FPlayers getFPlayers() {
		Deprecation.showDeprecationWarningForMethod("FactionsFramework#getFPlayers");
		return ((FPlayers) Factions.getHandler());
	}
	
	/**
	 * Log an error
	 * 
	 * @deprecated to be removed on 16/12/2016
	 * Use the err method instead 
	 */
	@Deprecated
	public final void logError(Exception e) {
		LogUtil.err(e);
	}
	
}
