# Factions Framework

My fork of <https://github.com/MarkehMe/FactionsFramework>

Currently very broken & uncompleted.

## Differences
* Less static.
* More "Vault-like". If you've ever used the Vault Chat/Permission/Eco libraries, you might find this to be somewhat similar.
* Completely separates the API from the plugin implementation
* Removes support for modifying commands. (for now at least, use upstream if you want this.)
* Pretty much a complete rewrite. (or will be, once I've finished it.)

## Compiling
Unlike upstream, Maven is used for compilation.

```bash
# Clone the repo
git clone https://github.com/lucko/FactionsFramework.git && cd FactionsFramework
# Use maven to compile
mvn validate
mvn package
```

## Licensing
It's a bit complicated. See the LICENSE file.