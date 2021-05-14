package me.bryangaming.spigot.module;

import me.bryangaming.common.SenderAnnotWrapper;
import me.bryangaming.common.part.TransformingPartFactory;
import me.bryangaming.common.sender.PlayerWrapper;
import me.bryangaming.common.sender.SenderWrapper;
import me.bryangaming.spigot.impl.PlayerWrapperImpl;
import me.bryangaming.spigot.impl.SenderWrapperImpl;
import me.fixeddev.commandflow.annotated.part.AbstractModule;
import me.fixeddev.commandflow.annotated.part.Key;
import me.fixeddev.commandflow.bukkit.factory.CommandSenderFactory;
import me.fixeddev.commandflow.bukkit.factory.PlayerPartFactory;

public class SpigotModule extends AbstractModule {

    @Override
    public void configure() {
        bindFactory(SenderWrapper.class, new TransformingPartFactory<>(
                new CommandSenderFactory(),
                SenderWrapperImpl::new,
                SenderWrapper.class));

        bindFactory(PlayerWrapper.class, new TransformingPartFactory<>(
                new PlayerPartFactory(),
                PlayerWrapperImpl::new,
                PlayerWrapper.class));

        bindFactory(new Key(PlayerWrapper.class, SenderAnnotWrapper.class), new PlayerPartFactory());
    }
}
