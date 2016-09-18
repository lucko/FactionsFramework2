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

package me.lucko.factionsframework.api;

import me.lucko.factionsframework.api.entities.FPlayer;
import me.lucko.factionsframework.api.entities.Faction;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import java.util.Set;
import java.util.UUID;

/**
 * Base interface in FactionsFramework
 */
public interface FactionsFrameworkApi {

    FactionsVersion getVersion();

    FPlayer getPlayer(CommandSender sender);
    FPlayer getPlayer(UUID uuid);
    FPlayer getPlayer(String name);


    Faction getFaction(String id);
    Faction getFaction(String id, String universe);
    Faction getFactionByName(String name, String universe);
    Faction getFaction(FPlayer player);
    Faction getFactionAt(Chunk chunk);
    Faction getFactionAt(Location location);
    Faction getNone(World world);
    Faction getWarZone(World world);
    Faction setSafeZone(World world);
    Set<Faction> getAllFactions();

}
