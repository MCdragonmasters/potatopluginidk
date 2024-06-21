package com.mcdragonmasters.potatopluginidk;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings({"unused", "RedundantSuppression", "deprecation"})
public class PotatoPluginIDK extends JavaPlugin {

    public static PotatoPluginIDK instance;
    public static FileConfiguration config;
    //private static Metrics metrics;
    private static final String prefix = net.md_5.bungee.api.ChatColor.of("#40ff00")
            + "[PotatoSK] " + ChatColor.RESET;

    public void onEnable() {

        instance = this;

        // Register Metrics
        //Metrics metrics = new Metrics(this, 22275);
        //metrics.addCustomChart(new SimplePie("skript_version", () -> Skript.getVersion().toString()));
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Potatoidkplugin has been enabled!");
        PluginManager pm = getServer().getPluginManager();
        if (!getDataFolder().exists()) {
            saveDefaultConfig();
        }

        config = getConfig();
        // Create our command
        new CommandAPICommand("broadcastmsg")
                .withArguments(new GreedyStringArgument("message")) // The arguments
                .withAliases("broadcast", "broadcastmessage")       // Command aliases
                .withPermission(CommandPermission.OP)               // Required permissions
                .executes((sender, args) -> {
                    String message = (String) args.get("message");
                    Bukkit.getServer().broadcastMessage(message);
                })
                .register();
    }
}
