package me.bryangaming.bungee;

import me.bryangaming.bungee.module.BungeeSenderModule;
import me.bryangaming.common.ModuleLoader;
import me.bryangaming.common.command.TestCommand;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bungee.BungeeCommandManager;
import me.fixeddev.commandflow.bungee.factory.BungeeModule;
import net.md_5.bungee.api.plugin.Plugin;

public class Bungee extends Plugin {
    
    @Override
    public void onEnable() {

        CommandManager commandManager = new BungeeCommandManager(this);

        PartInjector partInjector = new ModuleLoader(new BungeeModule(), new BungeeSenderModule()).getInjector();

        AnnotatedCommandTreeBuilder builder = new AnnotatedCommandTreeBuilderImpl(partInjector);
        commandManager.registerCommands(builder.fromClass(new TestCommand()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
