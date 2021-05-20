package me.bryangaming.bungee.module;

import me.bryangaming.bungee.impl.ProxiedPlayerImpl;
import me.bryangaming.bungee.impl.ProxiedSenderImpl;
import me.bryangaming.common.CommonSenderFactory;
import me.bryangaming.common.SenderAnnotWrapper;
import me.bryangaming.common.part.TransformingPartFactory;
import me.bryangaming.common.sender.PlayerWrapper;
import me.bryangaming.common.sender.SenderWrapper;
import me.fixeddev.commandflow.annotated.part.AbstractModule;
import me.fixeddev.commandflow.annotated.part.Key;
import me.fixeddev.commandflow.bungee.BungeeCommandManager;
import me.fixeddev.commandflow.bungee.factory.ProxiedPlayerPartFactory;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BungeeSenderModule extends AbstractModule {
    @Override
    public void configure() {
        bindFactory(SenderWrapper.class, new TransformingPartFactory<>(
                new ProxiedPlayerPartFactory(),
                ProxiedSenderImpl::new,
                SenderWrapper.class));

        bindFactory(PlayerWrapper.class, new TransformingPartFactory<>(new ProxiedPlayerPartFactory(),
                ProxiedPlayerImpl::new,
                PlayerWrapper.class));

        bindFactory(new Key(PlayerWrapper.class, SenderAnnotWrapper.class),
                new CommonSenderFactory(CommandSender.class,
                        ProxiedPlayer.class,
                        BungeeCommandManager.SENDER_NAMESPACE));
    }
}
