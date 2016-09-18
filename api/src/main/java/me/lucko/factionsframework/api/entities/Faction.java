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

import java.util.Optional;
import java.util.Set;

public interface Faction {
    
    String getId();
    String getName();
    String getDescription();
    void setDescription(String description);
    Set<FPlayer> getMembers();
    Set<FPlayer> getOfficers();
    Set<FPlayer> getMembersExcept(Relation... relations);
    Optional<FPlayer> getLeader();
    Location getHome();
    Set<Faction> getRelationsWith(Relation relation);
    Relation getRelationTo(Object obj);
    int getLandCount();
    double getPower();
    boolean isPermanentFaction();
    boolean isNone();
    Boolean quiteDisband();
    Boolean addMember(FPlayer fplayer);
    Boolean isValid();
    void msg(String msg);
    void msg(String msg, String... allocations);
}
