# Dropped Item Hider

![Dropped Item Hider icon](docs/icon.png)

A small Fabric mod for Minecraft `1.21.4` that hides dropped items from rendering.

That is the whole point of it. If you have farms dropping tons of kelp, cactus, mob drops, or anything else, the item piles can tank fps pretty hard. This mod lets you hide those dropped item visuals with one keybind.

## Info

- Version: `1.0.0`
- Minecraft: `1.21.4`
- Loader: Fabric
- Requires: Fabric API
- Java: `21`
- Default key: `K`

The keybind shows up in Minecraft's normal Controls menu, so you can rebind it if `K` conflicts with something else.

## How It Works

Dropped items start hidden by default.

Press `K` to toggle them:

- hidden
- visible
- hidden again

The mod remembers your last toggle state in:

```text
config/dropped-item-hider.txt
```

Inventory items, hotbar items, shop menus, and normal container item icons still show normally. This only affects dropped item entities in the world.

## Install

1. Install Fabric Loader for Minecraft `1.21.4`.
2. Install Fabric API.
3. Download `dropped-item-hider-1.0.0.jar` from Releases.
4. Put it in your `mods` folder.

## Build

Use Java `21`.

```powershell
.\gradlew.bat clean build
```

The jar will be in:

```text
build/libs/dropped-item-hider-1.0.0.jar
```

## Notes

This is meant to stay simple. No menus, no item filters, no extra modes. Just a keybind for hiding dropped item rendering.

## License

MIT
