package com.andrew.frostycore.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class SkullUtil {

    public static ItemStack getHead(String value) {
        ItemStack item = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner("MrBlizzards");
        item.setItemMeta(meta);
        ItemStack skull = item;
        UUID hashAsId = new UUID(value.hashCode(), value.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(skull,
                "{SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + value + "\"}]}}}"
        );
    }

    public enum Head {
        HEALTH_CHEST("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmI0MmM0ZDdlZmM1MTZmZTM0M2QyMWYxNDllZWQxNzg0MGRkMTUxZWI5NGZiZjZkZDhkNjZjYTgzNzdkY2VmNyJ9fX0="),
        HEALTH_KIT("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGEwOTcwN2RiNTE0MTk4ZThhZGE1MWRhZTk4NmZiNjYxYmJmMGJiMDk5YThlNDNkZTY2NDQxZmY2Y2JjM2QyYiJ9fX0="),
        SKULL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTJiYjljNjY2Mjc5YTlhZWViNTI1NTA5MWFhODI4ZjdkMWM0MjcxZTc3MzIxMjM5Y2Q2Y2VmMmU5NmJjOWY4OCJ9fX0="),
        SKULL_BURNING("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTcwYzU2YWE2ZmI3MjNjMDI0NWVlNTg2YTU5NjYxMzlhYzgzZjljMjllYTBjYzljMWVhYzc2NTVkZDY4MWQ3OSJ9fX0="),
        SKULL_RITUAL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzVkNWNhZTdlZDJmOTVjMGI3Y2ExMWYwMTQwNjQ5MDEzMjAwN2RhY2IzZDhiZTBkOWUxNjIwMTg3NDViMDFkMiJ9fX0="),
        SKULL_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFlNTVkMDA5ZTZiOGVhZTljNTgxOTUyMjNjZGNiODQxYjRjMGRmYmJiMDM4Njg0OGRjOGY2MGRlNGQyYzc5YiJ9fX0="),
        SKULL_AIR_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JlNjRmZWJlMTFiNzhkZGMzMmQyMzIxYTAwZjc3MzYxODM3NzQwNGJmZGY5ZjdhZDIzYTA5MDgxMjQwNzUxMCJ9fX0="),
        SKULL_FIRE_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmExZDgzNTg3NTg2ODIyZTIyMDRiYWI2M2ZiNmQ5YmMxYzY5YzA0ZGUyNDFjMmIwOTNhMmVmMTUxNTMwMzdkMSJ9fX0="),
        SKULL_EARTH_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTI4Y2NkZWNkNzc0M2MwMmRmN2E5MzRjNzNlYjI2YmE4MmQ3NTIxMzVmMzEzYTJjMmU1ZWIxYjM0Njc2MDJhNiJ9fX0="),
        SKULL_WATER_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzBmYmM1YWEwMDM5YjA0OGZhMWNlZmQ5YzA5NjM1NDdkYjVmNjMwZmMwY2Q4NDkyYjU0MjRmYmRjZDk1MzY5YSJ9fX0="),
        SKULL_ICE_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjg3ODVmN2U5NWNiYzlkNzg5ZDAzYjc4MWU0NzYxNjYwZjdiNGNlMWQ4ZGY2Y2IzZTIxYTdhZjUwOWU1NGJlNyJ9fX0="),
        SKULL_ELECTRIC_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQwZGNkMjM2ODBkNDNmZmM2MGIwYmUwYzIyZTIxOTM3MmJlMzgxMzI1MTkzOGIyYmU2ZmI2MjQwNWYzNTE1OSJ9fX0="),
        SKULL_CHAOS_RUNIC("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTRhMzg3ZTkwMjIwNGNlNmU1MjZhMTA0Y2UwMzJmZDE5NTFlYzBhNWYzYmFmM2I4OWEzMTNlZmRiODNlYjczMSJ9fX0="),
        YOUTUBE_PLAY_BUTTON_SILVER("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFjYWQzOWU2MWExYmQ5YjE3M2Q5YWY1ZDg1NDc5Zjk3OTY2YTE5OTkyYmM0MjhlMjQ4MWU0N2NlZjU4NWRkMCJ9fX0="),
        YOUTUBE_PLAY_BUTTON_GOLD("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmViYmZlOTFiZjc2MzI2ZTdjZDgzZjViNTg3MjgwN2E4NzVkMjQzNTEwZDhhZTJkYjVkMDIwMmYyMWQzYWU4NSJ9fX0="),
        TROPHY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM0YTU5MmE3OTM5N2E4ZGYzOTk3YzQzMDkxNjk0ZmMyZmI3NmM4ODNhNzZjY2U4OWYwMjI3ZTVjOWYxZGZlIn19fQ=="),
        CHEST_LOOT("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjJjNWY3YWM3MDZiMmU4YTg3OGViZjk3MmIwN2YzZDM2NDQ5YWI3MGIwOWFjZDk3M2VlYWJiMGQ1ZmM0YTZiNCJ9fX0="),
        MODERN_CLOCK_WHITE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjQ0ZWFkMmE3ZDk4YzA4NmJkYTExYWI1OTM3OTg3ZTY5ZjNjN2ZmNGY0NzdhMTk0MjdkN2FjMDIyYzY3ZmQ3NiJ9fX0="),
        MODERN_CLOCK_RED("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFiMjA3MmI4NGRhYmI0ZDkwZjYzMWYxOGJmZDIzOTg2MjM0OGM1ZDA1OGQ0ZTgzNGE0YTI4NWU0ZTI1ZjlmZiJ9fX0="),
        MAILBOX("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDY5MmRkYTNlYjNkNmZmNGNhYjcyMWNjNWMwZWY4ZjI5MWFjMGY5ZjFkYTlkZmRhODczY2IwOGM2ZTE5ODVkMiJ9fX0="),
        TELEVISION("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2FiMmMwMzY0NTBkZDEzNGNlNWQ2YmMwNjNmZTFkNzIwNzU1ZDAxZTg2OWY4YTQ3MWY2NWFjMmVlODRlMTE3In19fQ=="),
        COMPUTER("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2I5MDRlOGY2ZDk3NjhjZTZhYWNmNjViYWFiZDQ2ODMzNzRkYjM0NjQ5Y2UxZjM2MDc1NzBiMTZlY2FkZDM4NCJ9fX0="),
        MONITOR("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTVkMzFhODYxZjRlMzM3NDU5YjhhYmUwNTBlNmNlNDBjMTFjNzJkYWNkNzFkODMxYWNlMTI1MjM1MDBlMWIyNyJ9fX0="),
        OFFICE_PHONE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTQ3YmJkOThmNzM2NmY5MWRkODRiOGIyNTY1NDYwNDkyYjNjMzBjNjUwOTk5YjQ1MjYxMGQ5ZTkxZWQxMTI2ZiJ9fX0="),
        PURPLE_GEM("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQ2ODkzNWMyZGEwMTAzMGRjZWQxODZkNjg1MTdmNGNlNDgxNmY1YjhiNWMwZTYyNzA2NjFlODA1ODc4MjIzOCJ9fX0="),
        GOLDEN_GEM("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzM5MGM3MWNjOTQ3YWFiYzA1NzU4ZjNjNDk5NGEzMWZiNTgyMWZkNTE2ZjExYjBkOWUxOWU5YzQ3MWE2NDZmNyJ9fX0="),
        YELLOW_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmE0Mzg3OWU2MzQ1NjIwYmM2ODExZjdhMjhmMzFmYmRhOTg2ZDJhYjc2ZTQyM2UwYTE2MTMyMWVmYjI1OGI5NSJ9fX0="),
        BLUE_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2RhYWRmODJiYjY3ODI2ZDZkMzNjZTdkODY2ZDU0M2FlMzUxZWFmYWQ3Y2IzOWFhMzhlOTU4YTA1ZDY4OTI4NCJ9fX0="),
        PURPLE_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYThiZTFkZmM5Yjc0M2VhODM4ZDUzODNjMzA1YTlhYTVjNWE0MDNmYjY3MGZiYjUyMTBkNGMxNDNiYzliZjAyNiJ9fX0="),
        RED_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjMyZGVmYmJjNWQ1NWIyN2FlNzE5YjdiN2Q2ZGYwNjQxZTExNDVhYjcxOGIwYTI1YzQyYmVkMzUxMzA4OWM2MCJ9fX0="),
        BLACK_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWE1MmFmOTRkZWVkN2JiMzJhYjYyYmJkMGIyYWZiOTdlOTM1ODU4NjU5MTU1ODdjYjY0MTgzZWI3MTI5MzFlYyJ9fX0="),
        PINK_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFiZmYxMDMxNjVkZDQ5NDA4OTEwMjY0NTUyNDkzYjIwOTFiMGIwYmU5ZGNkYzJmOWIxZTNjNDEyNWU1NGIzYyJ9fX0="),
        ORANGE_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmRhNTg3MGFmNmI3ODIzN2Q2NDIwYjEzMGQ4YmMzNDMwZDc4NmU2NWE0ZTY4N2RjYzBkZjM3MDYzZmM4YzUwNiJ9fX0="),
        GREEN_BALL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmRhNTg3MGFmNmI3ODIzN2Q2NDIwYjEzMGQ4YmMzNDMwZDc4NmU2NWE0ZTY4N2RjYzBkZjM3MDYzZmM4YzUwNiJ9fX0="),
        LANTERN("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2MwYWEwMGQ2Mjg1ZGY2NzJkOWFjMTIyZGU0YjI0YjRhZTczNjM3NzFiMDQ1YmM0ZTMyNzNlZjg1Yzc1YzhkNSJ9fX0="),
        LANTERN_RED_BLUE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGU0ZTRjZGQ1NGJiNzVlZWE0YWFlNTdmN2RmOTI4YjcwNGE4MWNjN2JlMmEwY2Y4NDQ5NjZiOTIwZmM3ZmFiZCJ9fX0="),
        LANTERN_RED_WHITE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U4MGNlYmMyZWIwYTEzNDk2YjI3NGE5MDgxNThkNjEwNWJkYWYxYTUxZDgyZTVkMjQxN2JiNTVkZDIwZjRkYSJ9fX0="),
        LANTERN_RED_GREEN("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDQ4NzM5YzY4ODIzZDAyMzViOTI2MjUzMDJhNjYzYzAyYTA0ZmI0MjJmNTBhNDNkNmUzZjA4M2E3ZTRkMWExOCJ9fX0="),
        LANTERN_RED_PINK("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmI4YWFlMWFlNDU4MDhjODA3OTkzOTNkMDJhNGJmZmU1NTNlNjVhMzUzNGMxZTJjOGY4MGViZWMxYjRlZWUyYSJ9fX0="),
        LANTERN_BLACK_PINK("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWRlNWI0MDdiNjNjOTMxZWJkZjZiYjdjOTQ2NmUwNzQwNDdmZjUyOGNjYTYzZTNmMTQ4ODk3ZWM2ZjljZGQyIn19fQ=="),
        LANTERN_BLACK_WHITE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWM0YzQ0NGYzOWMwZjk4NDI1YjU2ODZjOTJlYmU2NDYwNTJhOTE3Yjc3MGFhOGU3NzE5MWFmOWUwOTExOWYxMCJ9fX0="),
        LANTERN_BLUE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE4ODViOTE4MTA0ZTZhYTYyYjZlYzliOGU4MjAyOGRkOWRhN2QyYWNkZmU5YzIxNTVlZGQzOTIyODViNTdlMSJ9fX0="),
        LANTERN_GREEN("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2I4ZDY2ODgwYmJkZmUxOTM5MjcxODcxZWMyNzhlMzg0NzZhMDc1OTA5MTg0YTYxM2FmZmVhYzQwNjIxZGFhYiJ9fX0="),
        LANTERN_RED("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg0OGIzMzNlMTQ3M2I5NTU3MTgyZDQ3NWI0ODZhYTc5YTA1ZTk0ZWJkMGE1MDEwMmQ3ODc3NjIzNjc5YWE2YyJ9fX0="),
        LANTERN_BLACK("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDNiNDhjYmZjOTUxNTU4ZGQyYTZhNDhlYjk4MWM0YjIwNjFiMjc2NDg3MjlkMzNhYTkwN2ZlNGU2MTU4MjgwIn19fQ=="),
        EGG_BLUE_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTFiOTgwM2ZjMGJmNDY3NTU5ZDVjYjRmNGFiMzM5YzliMDk3ZWE0YTgyYzVhMmE1MjZlOGIwMDkyNGQzZTM0NSJ9fX0="),
        EGG_BLUE_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzY5OWMyZjgyNDhkMDQ1MjdmZmEwNzdmZmUyYzdkMzA5M2Q1MmVmNzU1YWZjNDdiYmMxYTdjNjIwOTFmYzI3NiJ9fX0="),
        EGG_BLUE_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJkYWQ4NjhmOGQ4NjViYWEzMmQ2MTU4NjcyZDFiMTM0ZGI2MWVhNTZkMzNlZmEwYzA5ZjZiYTZmMjc2ZmYyIn19fQ=="),
        EGG_BLUE_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjMDQ0ZmVjNTkzMGRiYTQwMzUyODBlZTMyNTZjYzI0NDFhOGZmYjczMGNkOTBlOWU4MTliY2RlYTU2MjI3ZSJ9fX0="),
        EGG_BROWN_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjIwZmM0NDkwMWQ5ZGI4YTgyYzRlOTkzYjE4NjFjNDBkNjMxOTFjNDdiNDUzNWNmY2Y5YmIwOWY3ZTRkYTM0NCJ9fX0="),
        EGG_BROWN_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWFmZGIwNjVhZTI3Yzg4MTMzY2Y2YWNhMTQyMjg3M2RkNmUyOTc1NTY2MDY5ZThkODk3Y2JlMGFlYTNkODFjYiJ9fX0="),
        EGG_BROWN_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjE1MGExNmFiY2I3MDA5MmZiMGZkYmJkZTY1YTkyZGFiYzg2M2RlZTg5OTliMGRhNTJkOWEyZWMzNWI3MWEyYiJ9fX0="),
        EGG_BROWN_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQ0MzFjNjVlNDNiYWFmN2JjOThlMjI0NDQ4MmFhNTA5YWE0MjUyYmUzZWYxNzJmZjk3MDBkMTIwOGYzZjI0MSJ9fX0="),
        EGG_WHITE_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWM1MDJiYWEwMTBiZDdmODA0ZDQ0YmMxNjNjYmUwMDc4YzUwYzY1ZjhkYTc3MmE1MGRkNzg4M2U5N2VjNzg5ZCJ9fX0="),
        EGG_WHITE_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE4ZDE3MDI3MTY3YjlkZWZkODQ3OTdlY2MzMmU4N2RlNDRiNDA3NDBiOWExMTExMTcyNGIxMTQzMDBkZmVhYiJ9fX0="),
        EGG_WHITE_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmYyNTk0NGI3NDY1ZmY0NTg2YTM0MWY4ODFmNDg4YjZmOWQ0YjNmZmMxMDBmNTBhNzcwODcwNzViM2NlYjFiIn19fQ=="),
        EGG_WHITE_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzQyZWFlMTJiNjg0OWU1YTg2Zjg0NzczNWI5ZDY5ZTE4OWYzNjYwNjE1NmE1Yzk2ODU5ZjRlODljMjQzYTI5MyJ9fX0="),
        EGG_YELLOW_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFlN2M1OTgwNTIzOTczZDIzMjc4M2UwNGZiNjc4ZjIwMDM0ODExZDFkYWU2ZjljYmExOTk2M2YxZDNjOTI3OCJ9fX0="),
        EGG_YELLOW_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjMyY2Q2ODk2ZThlOGMxOWJiZmJlMWJkOTk1ZjlkMWFiNGY3YWUzOGVhZTY4MGQ0NDNmNzVkMmViMjM3MDZlOCJ9fX0="),
        EGG_YELLOW_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjU4MzRjNDJjYmZkYTM0YjU5MmJkYzlmZGFhYWM4MTc0YzI0YzE1ZWQ3NzA3OGRmNTBjZGVlMzBjOTgzMTA1NyJ9fX0="),
        EGG_YELLOW_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODUzMWNjMjY5YzhlNDcwNmU4OTJmOGEwZmIzNTFiMTA5MDE1NmIzZjYyNjFkODE2MzVkMDdhY2FkYmU2Y2UwZSJ9fX0="),
        EGG_PURPLE_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM5OTU5OTBjODQ2MjYzYTk4ZTgwZTY4NTZhMzUwZTE1NDcxY2RmNDU4NWIzYjk0NzZhMTE1MGQ0ODk1MGY5MCJ9fX0="),
        EGG_PURPLE_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTkwNzhkNGFhNmJiYWY3MDQ3ZGY1YjdiNmNmYjUyZjg2OTcwZTUwZjM5OTJmNGRlYmVjYzBjNTgwMTVlNzNjMiJ9fX0="),
        EGG_PURPLE_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWFkMzFmZDVhMThhODIwZjdkZmZkY2JkMmJjNTI5MmQyMjFhODk2NTE4ZTFjZmE4MDMxNDZlYjlhYmE3MjBiOCJ9fX0="),
        EGG_PURPLE_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODI0ZjBlODY1ZGU5ZTkwYjQ3OTQ1YWExMDliNTFmNWY3ZmQwYzNjODY4YjI1ZTE4MDk2YzBmNWFmOTFkYjE2NCJ9fX0="),
        EGG_RED_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDNmNTU3YWFkZDA5MzUxMDY5NThiOWNhNDc2OGJhNjg4YzUwNjhiOTAwZWE5ZGVhNDRkZTA0OWM2ODYzYzNkYyJ9fX0="),
        EGG_RED_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzBlZTNhMjk0NDUxNjAzOGQ0MmQ5YmUyODVmNzQ1NzBlNWMxNjYyZjY3NWVmMWIwN2YyOGVjZWJmNDY1OWY3MyJ9fX0="),
        EGG_RED_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGExYmUyY2M2N2UxNGY2OTk1MzZhMWUzZWQ1NjZlOWRmOWFkMjhmMjBiOGRlOTc3ODEzZTIxOWY0YTQ4ODJiMiJ9fX0="),
        EGG_RED_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjA0YzhjN2JhMWYwZGFlYTNiNDEwZWRkYjQ5OWQ1NjUwM2RkZGQ0NzQ2ZTgyMWE1YmRlNDUxM2I2Mjg3NGIxIn19fQ=="),
        EGG_GREEN_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDMyYWY5NTcyMTg2M2U3YjFiNDA4NTBiOWU0ODNhMzA3OGU5NGJiYjI2ZWQxNGMzY2NmMDEwZTMwZWVmYjY1NCJ9fX0="),
        EGG_GREEN_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2QwZGRlZDhhZGU0NjU0NzA5ZWEzMGI5MGM1ZWE0NTBhOGFhMzg3NGQxYTkyZTllYmMwZTBmMmMzMjQ2ZDg2ZiJ9fX0="),
        EGG_GREEN_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGUxOGY3ZTU2NGEwYTZjNWViM2MxYjAwNjQ3ZGIzOWM1NmI0ZGFiYjUyNmJjMDE0Mzg2MjZlNjdiZmYwY2UyYiJ9fX0="),
        EGG_GREEN_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjRlNzJiZDY5ZWIxZDNiYWE0MDBkMzZlMzA3MzZlZWQ5ZWZlZTBmMmQ4ZGFjNDM5OGI2OTUzMDk5YjVhNjRiIn19fQ=="),
        EGG_GRAY_COMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTRmOTlmNTA5YTRmMTU3NjM4YzNhOWM3NzViZmIzZDdiNjJlNzgxZTYxMjQxMDhmNjQ2NTExNWY4YTQxMmI1ZiJ9fX0="),
        EGG_GRAY_UNCOMMON("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWYwMjU2NGM0YzI5NjM1MGUxZGE5MzJlYTZiZDc5ZjFlYzAzZGExM2Y0YTQ5ZTliODBmOTZjOWJiOTAzZGNhZiJ9fX0="),
        EGG_GRAY_RARE("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzk4MmIzYmRmZTJmMGZjMDQ0MzliMGJmMGU3OWZiZDg2OWE0NmZmNzMzOTZkMzQ1OWE1YzdhNTE4NTdiMzMyNCJ9fX0="),
        EGG_GRAY_LEGENDARY("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWFmOTUxMDUwY2NkMWM3M2ZlZTRlMTM4Yzk1M2E0MmYwYzA3OGE5MmVkOGU2OTI2OTZiZjRhNjM5MTIyMDhkYyJ9fX0=");

        private String value;

        @Override
        public String toString() {
            return value;
        }

        Head(String value) {
            this.value = value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static ItemStack getHeadFromString(String s) {
            ItemStack headStack = null;
            for (Head head : Head.values()) {
                if (head.name().equals(s)) {
                    headStack = getHead(s);
                }
            }
            return headStack;
        }
    }
}
