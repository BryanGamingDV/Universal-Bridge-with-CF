package me.bryangaming.common.command;


import me.bryangaming.common.CommandSender;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;

public class TestCommand implements CommandClass {


    @Command(names = "test")
    public void onCommand(CommandSender player, String message){
        player.sendMessage(message);
    }
}