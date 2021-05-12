package me.bryangaming.spigot.command;

import me.bryangaming.common.CommandSender;
import me.bryangaming.spigot.impl.PlayerImpl;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandClass{

    @Command(names = "test")
    public void commandClass(@Sender Player player, String message){
        CommandSender senderManager = new PlayerImpl(player);
        senderManager.sendMessage(message);
    }
}
