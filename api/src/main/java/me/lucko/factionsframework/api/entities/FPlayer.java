/*
 * Copyright (c) 2016 Lucko (Luck) <luck@lucko.me>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.factionsframework.api.entities;

import me.lucko.factionsframework.api.Relation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collection;

public interface FPlayer {

    String getId();
    Player asBukkitPlayer();
    Faction getFaction();
    void setFaction(Faction faction);
    Relation getRelationTo(Object object);
    String getUniverse();
    void msg(String msg);
    Boolean isOnline();
    Relation getRole();
    void setRole(Relation role);
    Location getLocation();
    Faction getFactionAt();
    World getWorld();
    String getName();
    double getPowerBoost();
    void setPowerBoost(Double boost);
    boolean hasPowerBoost();
    double getPower();
    int getPowerRounded();
    boolean tryClaim(Faction faction, Location location);
    boolean tryClaim(Faction faction, Collection<Location> locations);
    
}
