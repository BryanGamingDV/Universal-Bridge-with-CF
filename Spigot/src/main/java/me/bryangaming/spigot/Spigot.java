package me.bryangaming.spigot;

import me.bryangaming.spigot.command.TestCommand;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spigot extends JavaPlugin {


    @Override
    public void onEnable() {
        CommandManager commandManager = new BukkitCommandManager("spigot");

        PartInjector partInjector = PartInjector.create();
        partInjector.install(new BukkitModule());

        AnnotatedCommandTreeBuilder builder = new AnnotatedCommandTreeBuilderImpl(partInjector);

        commandManager.registerCommands(builder.fromClass(new TestCommand()));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
