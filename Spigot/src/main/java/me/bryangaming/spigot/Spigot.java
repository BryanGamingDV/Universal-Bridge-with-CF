package me.bryangaming.spigot;

import me.bryangaming.common.command.TestCommand;
import me.bryangaming.spigot.module.SpigotModule;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.AbstractModule;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spigot extends JavaPlugin {


    @Override
    public void onEnable() {

        loadModules(new SpigotModule());

        CommandManager commandManager = new BukkitCommandManager("spigot");

        PartInjector partInjector = PartInjector.create();
        partInjector.install(new BukkitModule());

        AnnotatedCommandTreeBuilder builder = new AnnotatedCommandTreeBuilderImpl(partInjector);

        commandManager.registerCommands(builder.fromClass(new TestCommand()));

    }


    public void loadModules(AbstractModule... abstractModules){
        for (AbstractModule abstractModule : abstractModules){
            abstractModule.configure();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
