package me.bryangaming.bungee;

import me.bryangaming.common.command.TestCommand;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.AbstractModule;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.bungee.BungeeCommandManager;
import me.fixeddev.commandflow.bungee.factory.BungeeModule;
import net.md_5.bungee.api.plugin.Plugin;

public class Bungee extends Plugin {
    
    @Override
    public void onEnable() {

        loadModules(new BungeeModule());

        CommandManager commandManager = new BungeeCommandManager(this);

        PartInjector partInjector = PartInjector.create();
        partInjector.install(new BungeeModule());

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
