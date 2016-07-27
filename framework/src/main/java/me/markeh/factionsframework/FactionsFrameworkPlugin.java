package me.markeh.factionsframework;

import org.bukkit.plugin.java.JavaPlugin;

public class FactionsFrameworkPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        if (FactionsFramework.isLoaded()) {
            throw new IllegalStateException("Another plugin (" + FactionsFramework.get().getLoadedBy().getName() +
                    ") has already loaded FactionsFramework. If you want FactionsFramework to be loaded by this plugin, " +
                    "add 'FactionsFramework' as a (soft)dependency in the plugins 'plugin.yml'.");
        }

        FactionsFramework.load(this);
    }

    @Override
    public void onDisable() {
        FactionsFramework.get().stop();
    }

}
