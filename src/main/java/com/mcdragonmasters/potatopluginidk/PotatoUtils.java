package com.mcdragonmasters.potatopluginidk;
import com.shanebeestudios.skbee.api.wrapper.ComponentWrapper;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
@SuppressWarnings("unused")
public class PotatoUtils {
    public static void test(String msg) {
        sendMessage((Component) fromMiniMessage("<rainbow>POTATOOOOOo"));
    }

    public static void sendMessage(@NotNull Component message, Player... players) {
        for (Player player : players) {
            player.sendMessage(message);
        }
    }

    public static ComponentWrapper fromMiniMessage(@NotNull String string) {
        return ComponentWrapper.fromMiniMessage(string);
    }
}

