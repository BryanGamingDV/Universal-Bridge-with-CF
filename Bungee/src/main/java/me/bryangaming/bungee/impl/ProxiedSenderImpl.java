package me.bryangaming.bungee.impl;

import me.bryangaming.common.sender.SenderWrapper;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.List;

public class ProxiedSenderImpl implements SenderWrapper {

    private final CommandSender commandSender;

    public ProxiedSenderImpl(CommandSender commandSender){
        this.commandSender = commandSender;

    }

    @Override
    public void sendMessage(String message) {
        commandSender.sendMessage(TextComponent.fromLegacyText(message));
    }

    @Override
    public void sendMessage(List<String> messages) {
        messages.forEach(message -> commandSender.sendMessage(TextComponent.fromLegacyText(message)));
    }

    @Override
    public String getName(){
        return commandSender.getName();
    }

    @Override
    public boolean hasPermission(String permission) {
        return commandSender.hasPermission(permission);
    }


}
