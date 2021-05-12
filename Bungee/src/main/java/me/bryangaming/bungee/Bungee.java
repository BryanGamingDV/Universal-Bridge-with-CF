package me.bryangaming.bungee;

import me.bryangaming.bungee.command.TestCommand;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.bungee.BungeeCommandManager;
import me.fixeddev.commandflow.bungee.factory.BungeeModule;
import net.md_5.bungee.api.plugin.Plugin;

public final class Bungee extends Plugin {
    
    @Override
    public void onEnable() {
        CommandManager commandManager = new BungeeCommandManager(this);

        PartInjector partInjector = PartInjector.create();
        partInjector.install(new BungeeModule());

        AnnotatedCommandTreeBuilder builder = new AnnotatedCommandTreeBuilderImpl(partInjector);

        commandManager.registerCommands(builder.fromClass(new TestCommand()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
