package me.bryangaming.bungee.command;

import me.bryangaming.bungee.player.ProxiedImpl;
import me.bryangaming.common.CommandSender;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bungee.annotation.Sender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class TestCommand implements CommandClass{

    @Command(names = "test")
    public void commandClass(@Sender ProxiedPlayer player, String message){
        CommandSender senderManager = new ProxiedImpl(player);

        senderManager.sendMessage(message);
    }
}
