package me.markeh.factionsframework.layer.layer_1_6;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import me.lucko.factionsframework.api.FactionsFrameworkApi;
import me.lucko.factionsframework.api.entities.FPlayer;
import me.lucko.factionsframework.api.entities.Faction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collection;

public class FPlayer_1_6 implements FPlayer {
	private final FactionsFrameworkApi api;
	private final boolean console;
	private String id;
	private com.massivecraft.factions.FPlayer player;
	
	public FPlayer_1_6(String id, FactionsFrameworkApi api) {
		this.api = api;
		this.id = id;
		this.console = id.equals("@console");

		this.player = console ? null : com.massivecraft.factions.FPlayers.getInstance().getById(id);
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public Player asBukkitPlayer() {
		return this.player.getPlayer();
	}
	
	@Override
	public Faction getFaction() {
		return console ? api.getNone(this.player.getPlayer().getWorld()) : api.getFaction(this.player.getFaction().getId());
	}

	@Override
	public void setFaction(Faction faction) {
		if (console) return;
		this.player.setFaction(com.massivecraft.factions.Factions.getInstance().getFactionById(faction.getId()));
	}

	@Override
	public me.lucko.factionsframework.api.Relation getRelationTo(Object object) {
		if (console) return me.lucko.factionsframework.api.Relation.NEUTRAL;
		
		if (object instanceof Faction) {
			object = com.massivecraft.factions.Factions.getInstance().getFactionById(((Faction) object).getId());
		}
		
		if (object instanceof FPlayer) {
			object = com.massivecraft.factions.FPlayers.getInstance().getById(((FPlayer) object).getId());
		}
		
		if (object instanceof Player) {
			object = com.massivecraft.factions.FPlayers.getInstance().getByPlayer(((Player) object));
		}
		
		Relation relation = this.player.getRelationTo((RelationParticipator) object);
		return Factions_1_6.convertRelationship(relation);
	}

	@Override
	public String getUniverse() {
		return "default";
	}

	@Override
	public void msg(String msg) {
		if (console) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			return;
		}
		
		this.player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	@Override
	public Boolean isOnline() {
		return console || this.player.isOnline();
	}

	@Override
	public me.lucko.factionsframework.api.Relation getRole() {
		switch (this.player.getRole()) {
			case ADMIN:
				return me.lucko.factionsframework.api.Relation.LEADER;
			case MODERATOR:
				return me.lucko.factionsframework.api.Relation.OFFICER;
			default:
				return me.lucko.factionsframework.api.Relation.MEMBER;
		}
	}

	@Override
	public void setRole(me.lucko.factionsframework.api.Relation role) {
		if (role == me.lucko.factionsframework.api.Relation.LEADER) {
			this.player.setRole(Role.ADMIN);
			return;
		}
		
		if (role == me.lucko.factionsframework.api.Relation.OFFICER) {
			this.player.setRole(Role.MODERATOR);
			return;
		}
		
		this.player.setRole(Role.NORMAL);
	}

	@Override
	public Location getLocation() {
		return this.player.getPlayer().getLocation();
	}
	
	@Override
	public Faction getFactionAt() {
		return api.getFaction(Board.getInstance().getFactionAt(this.player.getLastStoodAt()).getId());
	}
	
	@Override
	public World getWorld() {
		return this.player.getPlayer().getWorld();
	}

	@Override
	public String getName() {
		return this.player.getName();
	}

	@Override
	public double getPowerBoost() {
		return this.player.getPowerBoost();
	}

	@Override
	public void setPowerBoost(Double boost) {
		this.player.setPowerBoost(boost);
	}

	@Override
	public boolean hasPowerBoost() {
		return (this.getPower() != 0D);
	}

	@Override
	public double getPower() {
		return this.player.getPower();
	}

	@Override
	public int getPowerRounded() {
		return (int) Math.floor(this.getPower());
	}

	@Override
	public boolean tryClaim(Faction faction, Location location) {
		return this.player.attemptClaim(com.massivecraft.factions.Factions.getInstance().getFactionById(faction.getId()), location, true);
	}

	@Override
	public boolean tryClaim(Faction faction, Collection<Location> locations) {
		for (Location location : locations) {
			if (! this.tryClaim(faction, location)) return false;
		}
		return true;
	}
	
}
