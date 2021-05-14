package me.bryangaming.spigot;

import me.bryangaming.common.ModuleLoader;
import me.bryangaming.common.command.TestCommand;
import me.bryangaming.spigot.module.SpigotModule;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.fixeddev.commandflow.bungee.factory.BungeeModule;
import org.bukkit.plugin.java.JavaPlugin;

public class Spigot extends JavaPlugin {


    @Override
    public void onEnable() {

        CommandManager commandManager = new BukkitCommandManager("spigot");

        PartInjector partInjector = new ModuleLoader(new SpigotModule(), new BukkitModule()).getInjector();

        AnnotatedCommandTreeBuilder builder = new AnnotatedCommandTreeBuilderImpl(partInjector);

        commandManager.registerCommands(builder.fromClass(new TestCommand()));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
