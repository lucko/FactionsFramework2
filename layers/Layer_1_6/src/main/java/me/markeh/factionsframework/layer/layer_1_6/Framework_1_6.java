package me.markeh.factionsframework.layer.layer_1_6;

import me.lucko.factionsframework.api.FactionsFrameworkApi;
import me.lucko.factionsframework.api.FactionsVersion;
import me.lucko.factionsframework.api.entities.FPlayer;
import me.lucko.factionsframework.api.entities.Faction;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Framework_1_6 implements FactionsFrameworkApi {
    private final Framework_1_6 instance = this;
    private Map<String, FPlayer> players = new HashMap<>();

    @Override
    public FactionsVersion getVersion() {
        return FactionsVersion.FACTIONS_1_6;
    }

    @Override
    public FPlayer getPlayer(CommandSender sender) {
        return this.getPlayer(sender instanceof Player ? ((Player)sender).getUniqueId() : null);
    }

    @Override
    public FPlayer getPlayer(UUID uuid) {
        String id = uuid == null ? "@console" : uuid.toString();
        return players.computeIfAbsent(id, s -> new FPlayer_1_6(id, instance));
    }

    @SuppressWarnings("deprecation")
    @Override
    public FPlayer getPlayer(String name) {
        return this.getPlayer(Bukkit.getPlayer(name).getUniqueId());
    }

    @Override
    public Faction getFaction(String id) {
        return null;
    }

    @Override
    public Faction getFaction(String id, String universe) {
        return null;
    }

    @Override
    public Faction getFactionByName(String name, String universe) {
        return null;
    }

    @Override
    public Faction getFaction(FPlayer player) {
        return null;
    }

    @Override
    public Faction getFactionAt(Chunk chunk) {
        return null;
    }

    @Override
    public Faction getFactionAt(Location location) {
        return null;
    }

    @Override
    public Faction getNone(World world) {
        return null;
    }

    @Override
    public Faction getWarZone(World world) {
        return null;
    }

    @Override
    public Faction setSafeZone(World world) {
        return null;
    }

    @Override
    public Set<Faction> getAllFactions() {
        return null;
    }
}
