# Donut AH Search

Donut AH Search is a client-side Fabric mod designed for economy and SMP servers with an Auction House (such as DonutSMP). It allows you to search the auction house for whatever item you are holding in your hand with a single keypress.

---

### Key Features

- **One-Key Search:** Press `0` (default hotkey, fully configurable in Controls) to search `/ah` for the item in your main hand.
- **Enchantment Detection:** Automatically reads enchantments on tools, weapons, armor, and enchanted books, converting Roman numerals into numbers (e.g., Sharpness V becomes `sharpness 5`).
- **Exact Tooltip Matching:** Uses the in-game display name for items like potions, tipped arrows, and renamed items (color codes are stripped automatically).
- **Customizable Prefix:** Change the search prefix if your server uses `/auctionhouse`, `/search`, or `/ah`.
- **Client-Side Only:** Does not require server-side installation.

---

### In-Game Commands

| Command | Description |
|---|---|
| `/ahsearch prefix <prefix>` | Set custom command prefix (default: `ah`) |
| `/ahsearch mode <DISPLAY_NAME\|ID>` | Toggle search mode (`DISPLAY_NAME` or `ID`) |
| `/ahsearch status` | View current prefix and search mode settings |

---

### Repository Structure

```text
donut-ah-search/
├── dist/                      # Pre-built release JARs for all supported versions
│   ├── donut-ah-search-1.0.0-mc1.21.11-fabric.jar
│   ├── donut-ah-search-1.0.1-mc26.1-fabric.jar
│   ├── donut-ah-search-1.0.2-mc26.1.1-fabric.jar
│   ├── donut-ah-search-1.0.3-mc26.1.2-fabric.jar
│   └── donut-ah-search-1.0.4-mc26.2-fabric.jar
├── mc-1.21.11/                # Source & Gradle build for Minecraft 1.21.x (Java 21)
├── mc-26.2/                   # Source & Gradle build for Minecraft 26.x (Java 25)
├── .github/workflows/         # Automated CI workflows
├── project_icon.png           # 256x256 pixel art mod icon (compliant with Modrinth)
├── modrinth_description.md    # Description page for Modrinth listing
├── LICENSE                    # MIT License
└── README.md                  # Project documentation
```

---

### Building From Source

#### Prerequisites
- **Java 21** (for `mc-1.21.11`)
- **Java 25** (for `mc-26.2`)

#### Minecraft 1.21.x:
```bash
cd mc-1.21.11
./gradlew build
```

#### Minecraft 26.x:
```bash
cd mc-26.2
./gradlew build
```

---

### License

This project is licensed under the [MIT License](./LICENSE).
