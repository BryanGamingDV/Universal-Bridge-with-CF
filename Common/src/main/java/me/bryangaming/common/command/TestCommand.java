package me.bryangaming.common.command;


import me.bryangaming.common.SenderAnnotWrapper;
import me.bryangaming.common.sender.PlayerWrapper;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.OptArg;

public class TestCommand implements CommandClass {

    @Command(names = "test")
    public boolean onCommand(@SenderAnnotWrapper PlayerWrapper sender, @OptArg("") String message){
        sender.sendMessage(message);
        return true;
    }
}
