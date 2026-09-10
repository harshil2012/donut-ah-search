# AH Search+

**AH Search+** is a complete, client-side Minecraft Fabric mod for Minecraft 26.2 using Java 25.

It automatically reads the item currently held in your main hand (including its ID and enchantments) and executes an Auction House search command in chat.

## Features

- **Hotkey Trigger:** Press **0** (configurable through standard Controls menu) to search for the held item.
- **Readable Search Query:** Formats the registry names into a lowercase human-readable string (e.g., `diamond_sword` -> `diamond sword`).
- **Enchantment Support:** Appends the item's enchantments and levels in Arabic numerals (e.g., `sharpness 5 looting 3`).
- **Modded Item Support:** Works with any modded items and modded enchantments out of the box (e.g., `mymod:ruby_sword` -> `ruby sword`).
- **Configurable Command Prefix:** The command prefix can be customized in the `config/ahsearch.json` file.
- **Client-Side Only:** No server-side installation required.

## Examples

| Hand Content | Search Query Sent |
|---|---|
| **Dirt** | `/ah dirt` |
| **Diamond Sword** | `/ah diamond sword` |
| **Diamond Sword** (Looting III) | `/ah diamond sword looting 3` |
| **Diamond Sword** (Sharpness V, Looting III) | `/ah diamond sword sharpness 5 looting 3` |
| **Netherite Pickaxe** (Efficiency V, Fortune III, Unbreaking III) | `/ah netherite pickaxe efficiency 5 fortune 3 unbreaking 3` |
| **Ruby Sword** (Sharpness VI) | `/ah ruby sword sharpness 6` |

## Configuration

The configuration file is generated at `.minecraft/config/ahsearch.json`.

```json
{
  "commandPrefix": "ah"
}
```

*Note: You can specify either `"ah"` or `"/ah"`; the mod automatically handles formatting the command packet.*

## Setup and Building

1. Ensure you have **JDK 25** (or newer) installed.
2. Build the project using Gradle:
   ```cmd
   ./gradlew build
   ```
3. Run the client using the developer environment:
   ```cmd
   ./gradlew runClient
   ```

## License

This project is available under the MIT License.
