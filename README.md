# 🍩 Donut AH Search

**Donut AH Search** is a clean, lightweight, and super-fast client-side Fabric mod for Minecraft that lets you instantly search the Auction House (`/ah`) for whatever item you are holding in your main hand with a single keystroke.

Developed and maintained by **hyy_shadow**.

---

## ✨ Features

- **⚡ Instant 1-Click Search**: Hold any item in your main hand and press `0` (configurable in Controls) to search the Auction House immediately.
- **🎯 Perfect Tooltip & Name Matching**: Uses exact in-game tooltip display names, working seamlessly for:
  - 🏹 **Tipped Arrows**: *Arrow of Healing*, *Arrow of Slowness*, *Arrow of Poison*, etc.
  - 🧪 **Potions**: *Potion of Regeneration*, *Splash Potion of Regeneration*, *Lingering Potion of Harming*, etc.
  - 🛒 **Minecart Variants**: *Minecart with Hopper*, *Minecart with TNT*, etc.
  - 🥩 **Foods & Resources**: *Steak*, *Golden Apple*, etc.
  - 🏷️ **Custom Renamed Items**: Strips anvil formatting and color codes (`§`) cleanly.
- **📚 Enchanted Books & Equipment**: Detects stored enchantments (e.g. *Sharpness V*, *Protection IV*) and appends them automatically (e.g. `/ah enchanted book sharpness 5`).
- **💬 On-Screen Feedback**: Displays clean confirmation of the exact `/ah` search sent.
- **⚙️ Fully Configurable**: Change command prefixes (`/ah`, `/auctionhouse`, `/search`) and search modes on the fly.

---

## 🎮 In-Game Commands

| Command | Description |
|---|---|
| `/ahsearch prefix <prefix>` | Set custom command prefix (default: `ah`) |
| `/ahsearch mode <name/id>` | Set search mode (`DISPLAY_NAME` or `ID`) |
| `/ahsearch status` | View current prefix and search mode settings |

---

## 📂 Repository Structure

This repository is organized to support multiple Minecraft versions across different Java baselines:

```text
donut-ah-search/
├── dist/                      # Pre-built, ready-to-use mod JARs for all releases
│   ├── donut-ah-search-1.0.0-mc1.21.11-fabric.jar
│   ├── donut-ah-search-1.0.1-mc26.1-fabric.jar
│   ├── donut-ah-search-1.0.2-mc26.1.1-fabric.jar
│   ├── donut-ah-search-1.0.3-mc26.1.2-fabric.jar
│   └── donut-ah-search-1.0.4-mc26.2-fabric.jar
├── mc-1.21.11/                # Source code and Gradle build for Minecraft 1.21.x (Java 21)
├── mc-26.2/                   # Source code and Gradle build for Minecraft 26.x (Java 25)
├── .github/workflows/         # GitHub Actions automated build CI
├── modrinth_description.md    # Description page for Modrinth release
├── LICENSE                    # CC0 1.0 Universal License
└── README.md                  # Project documentation
```

---

## 🛠️ Building From Source

### Prerequisites
- **Java 21** (for building `mc-1.21.11`)
- **Java 25** (for building `mc-26.2`)

### Build Minecraft 1.21.x Version
```bash
cd mc-1.21.11
./gradlew build
```
The output JAR will be generated in `mc-1.21.11/build/libs/`.

### Build Minecraft 26.x Version
```bash
cd mc-26.2
./gradlew build
```
The output JAR will be generated in `mc-26.2/build/libs/`.

---

## 📦 Releases & Mod Downloads

All pre-compiled release JAR files are stored in the [`dist/`](./dist/) directory for easy access and backup.

---

## 📜 License

This project is licensed under the [CC0 1.0 Universal License](./LICENSE).
