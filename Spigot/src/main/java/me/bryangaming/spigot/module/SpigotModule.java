package me.bryangaming.spigot.module;

import me.bryangaming.common.SenderAnnotWrapper;
import me.bryangaming.common.CommonSenderFactory;
import me.bryangaming.common.part.TransformingPartFactory;
import me.bryangaming.common.sender.PlayerWrapper;
import me.bryangaming.common.sender.SenderWrapper;
import me.bryangaming.spigot.impl.PlayerWrapperImpl;
import me.bryangaming.spigot.impl.SenderWrapperImpl;
import me.fixeddev.commandflow.annotated.part.AbstractModule;
import me.fixeddev.commandflow.annotated.part.Key;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.CommandSenderFactory;
import me.fixeddev.commandflow.bukkit.factory.PlayerPartFactory;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class  SpigotModule extends AbstractModule {

    @Override
    public void configure() {
        bindFactory(SenderWrapper.class, new TransformingPartFactory<CommandSender, SenderWrapper>(
                new CommandSenderFactory(),
                SenderWrapperImpl::new,
                SenderWrapper.class));

        bindFactory(PlayerWrapper.class, new TransformingPartFactory<Player, PlayerWrapper>(
                new PlayerPartFactory(),
                PlayerWrapperImpl::new,
                PlayerWrapper.class));

        bindFactory(new Key(PlayerWrapper.class, SenderAnnotWrapper.class), new CommonSenderFactory(
                        CommandSender.class,
                        Player.class,
                        BukkitCommandManager.SENDER_NAMESPACE));
    }
}
