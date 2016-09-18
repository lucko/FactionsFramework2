package me.markeh.factionsframework.plugin;

import me.lucko.factionsframework.api.FactionsFrameworkApi;
import me.lucko.factionsframework.api.FactionsVersion;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionsFrameworkPlugin extends JavaPlugin {
    private FactionsFrameworkApi impl;
    private FactionsVersion version;

    @Override
    public void onEnable() {
        try {
            version = determineVersion();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        if (version == null) {
            getLogger().severe("Couldn't hook with Factions. Are you sure it's installed?");
            getLogger().severe("Make sure you're using FactionsUUID (1.6.9.5-U), FactionsOne(1.8.x), or Factions 2.5+.");
            throw new RuntimeException("Unable to load. Factions version could not be identified.");
        }

        try {
            impl = (FactionsFrameworkApi) getLayerClass(version).newInstance();
        } catch (Throwable t) {
            getLogger().severe("Couldn't get the FactionsFramework layer for your version.");
            throw new RuntimeException("Unable to load. Couldn't get layer.", t);
        }




    }


    @Override
    public void onDisable() {

    }
    
    private Class<?> getLayerClass(FactionsVersion version) throws Exception {
        String versionString = version.name().substring("FACTIONS_".length());
        return Class.forName("me.markeh.factionsframework.layer.layer_" + versionString + ".Framework_" + versionString);
    }
    
    private FactionsVersion determineVersion() {
        // Fetch the Factions plugin and ensure it exists 
        if (!getServer().getPluginManager().isPluginEnabled("Factions")) {
            return null;
        }
        
        String factionsVersion = getServer().getPluginManager().getPlugin("Factions").getDescription().getVersion();

        if (factionsVersion.startsWith("1.6.9.5-U")) {
            // Factions UUID starts with '1.6.9.5-U', we only support the latest version of FactionsUUID
            return FactionsVersion.FACTIONS_1_6;
            
        } else if (factionsVersion.startsWith("1.8")) {
            return FactionsVersion.FACTIONS_1_8;
            
        } else if (factionsVersion.startsWith("2.")) {
            // Is a 2.x variation, however there are lots of changes through these minor releases we can use to determine the version.
            // Factions >= 2.8.15 has new TypeDamageModifier
            
            try {
                Class.forName("com.massivecraft.massivecore.command.type.enumeration.TypeDamageModifier");
                return FactionsVersion.FACTIONS_2_8_16;
            } catch (Exception ignored) {}

            // must be an older version ..
            
            try {
                // Factions Versions <= 2.6 use the universe system (or is unsupported) 
                Class.forName("com.massivecraft.factions.entity.UPlayer");
                return FactionsVersion.FACTIONS_2_6;
            } catch (Exception ignored) {}

            try {
                // Factions Versions <= 2.8.6 has Spigot integration in an older spot 
                Class.forName("com.massivecraft.factions.spigot.SpigotFeatures");

                try {
                    Class.forName("com.massivecraft.massivecore.cmd.arg.ARString");
                    // Only different between 2.8.2 and 2.8.6 is command versioning

                    try {
                        Class.forName("com.massivecraft.massivecore.MassiveException");
                        return FactionsVersion.FACTIONS_2_8_2;
                    } catch (Exception e) {
                        return FactionsVersion.FACTIONS_2_7;
                    }

                } catch (Exception ignored) {}

                return FactionsVersion.FACTIONS_2_8_6;
            } catch (Exception ignored) {}

            try {
                Class.forName("com.massivecraft.massivecore.command.MassiveCommandHelp");
            } catch (Exception e) {
                return FactionsVersion.FACTIONS_2_8_7;
            }

            // We assume it's a more recent version of Factions 
            return FactionsVersion.FACTIONS_2_8_8;
        }
        
        return null;
    }

}
