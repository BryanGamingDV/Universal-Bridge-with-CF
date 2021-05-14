package me.bryangaming.common.command;


import me.bryangaming.common.SenderAnnotWrapper;
import me.bryangaming.common.sender.PlayerWrapper;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;

public class TestCommand implements CommandClass {


    @Command(names = "test")
    public void onCommand(@SenderAnnotWrapper PlayerWrapper sender, String message){
        sender.sendMessage(message);
    }
}
