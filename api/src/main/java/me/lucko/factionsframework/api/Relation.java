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

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Getter
@AllArgsConstructor
public enum Relation {

    ENEMY("an enemy", "enemies", "an enemy faction", "enemy factions", setOf("Enemy")),
    NEUTRAL("someone neutral to you", "those neutral to you", "a neutral faction", "neutral factions", setOf("Neutral")),
    TRUCE("someone in truce with you", "those in truce with you", "a faction in truce", "factions in truce", setOf("Truce")),
    ALLY("an ally", "allies", "an allied faction", "allied factions", setOf("Ally")),
    RECRUIT("a recruit in your faction", "recruits in your faction", "", "", setOf("Recruit")),
    MEMBER("a member in your faction", "members in your faction", "your faction", "your factions", setOf("Member")),
    OFFICER("an officer in your faction", "officers in your faction", "", "", setOf("Officer", "Moderator")),
    LEADER("your faction leader", "your faction leader", "", "", setOf("Leader", "Admin", "Owner"));

    private final String descriptionPlayerSingular;
    private final String descriptionPlayerPlural;
    private final String descriptionFactionSingular;
    private final String descriptionFactionPlural;
    private final Set<String> names;

    public int getValue() {
        return this.ordinal();
    }

    public String getName() {
        return this.getNames().iterator().next();
    }

    @SafeVarargs
    private static <T> Set<T> setOf(T... of) {
        return Collections.unmodifiableSet(new TreeSet<>(Arrays.asList(of)));
    }

}
