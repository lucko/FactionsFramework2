# Factions Framework

Fork of <https://github.com/MarkehMe/FactionsFramework>

Differences: Uses Maven. (see below)

## What is Factions Framework?

Factions Framework is best described as a middle man. It sits in-between your plugin and the Factions plugin you have installed.

The framework has it's own standard for creating commands, getting factions, using events, and other features required for Factions plugins. This means that you only have to create your plugin to work with Factions Framework. These are automatically routed into Factions, using the correct standard for your installed plugin.

In some cases, Factions Framework is more powerful than using the existing Factions API. We've extended on the features in events and other classes, allowing you to do more things easily.

Factions Framework supports Factions UUID (1.6), FactionsOne (1.8) and most versions of Factions 2.

## Compiling
Unlike upstream, Maven is used for compilation. (There's no good reason for this, you should use upstream. I wanted it for something specific.)

```bash
# Clone the repo
git clone https://github.com/lucko/FactionsFramework.git && cd FactionsFramework
# Use maven to compile
mvn validate
mvn package
```