# Donut AH Search

Donut AH Search is a client-side Fabric utility mod designed for economy servers with an Auction House (such as DonutSMP). It allows you to search the auction house for whatever item you are holding in your hand with a single keypress.

---

### Why use this mod?

Typing out long auction house commands like `/ah enchanted book sharpness 5` or `/ah netherite sword sharpness 5 unbreaking 3` takes time, especially when comparing prices or looking for quick snipes. 

With Donut AH Search:
1. Hold any item or enchanted book in your main hand.
2. Press **0** (default hotkey, fully configurable in Controls).
3. The mod formats the item name and enchantments and sends the search command automatically.

---

### Key Features

- **One-Key Search:** Press `0` to instantly search `/ah` for the item in your main hand.
- **Enchantment Detection:** Automatically reads enchantments on tools, armor, weapons, and enchanted books, converting Roman numerals into numbers (e.g., Sharpness V becomes `sharpness 5`).
- **Exact Tooltip Matching:** Uses the clean in-game display name for items like potions, tipped arrows, and renamed items (color codes are stripped automatically).
- **Customizable Prefix:** Change the search prefix if your server uses `/auctionhouse`, `/search`, or `/ah`.
- **Purely Client-Side:** Does not require server-side installation. Works on any multiplayer server that supports auction house commands.

---

### Examples

| Held Item | Command Sent |
|---|---|
| Diamond Sword | `/ah diamond sword` |
| Diamond Sword *(Sharpness V, Looting III)* | `/ah diamond sword sharpness 5 looting 3` |
| Enchanted Book *(Mending I)* | `/ah enchanted book mending 1` |
| Netherite Pickaxe *(Efficiency V, Fortune III, Unbreaking III)* | `/ah netherite pickaxe efficiency 5 fortune 3 unbreaking 3` |
| Potion of Regeneration | `/ah potion of regeneration` |
| Arrow of Slowness | `/ah arrow of slowness` |

---

### In-Game Commands

You can configure settings directly in game without restarting Minecraft:

- `/ahsearch prefix <prefix>` &mdash; Sets the command prefix (default: `ah`).
- `/ahsearch mode <DISPLAY_NAME|ID>` &mdash; Toggles between using display tooltip names or raw registry item IDs.
- `/ahsearch status` &mdash; Prints your current prefix and search mode settings.

Configuration is automatically saved in `.minecraft/config/ahsearch.json`.

---

### Requirements & Installation

1. Install **Fabric Loader** for your Minecraft version.
2. Ensure **Fabric API** is installed in your `mods` folder.
3. Drop `donut-ah-search-*.jar` into your `.minecraft/mods` folder.

---

### Source & Issues

- Source Code: [GitHub](https://github.com/harshil2012/donut-ah-search)
- Issue Tracker: [GitHub Issues](https://github.com/harshil2012/donut-ah-search/issues)
- License: [MIT License](https://github.com/harshil2012/donut-ah-search/blob/main/LICENSE)
