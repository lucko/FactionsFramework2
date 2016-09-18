package me.lucko.factionsframework;

import lombok.experimental.UtilityClass;
import me.lucko.factionsframework.api.FactionsFrameworkApi;

/**
 * Registers the API provider
 */
@UtilityClass
public class ApiRegistrant {

    public static void register(FactionsFrameworkApi provider) {
        FactionsFramework.registerProvider(provider);
    }

    public static void unregister() {
        FactionsFramework.unregisterProvider();
    }
}
