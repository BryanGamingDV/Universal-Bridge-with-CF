package me.bryangaming.spigot.impl;

import me.bryangaming.common.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PlayerImpl implements CommandSender{

    private final Player player;

    public PlayerImpl(Player player){
        this.player = player;
    }

    @Override
    public void sendMessage(String message) {
        player.sendMessage(message);
    }

    @Override
    public void sendMessage(List<String> messages){
        messages.forEach(player::sendMessage);
    }


    @Override
    public String getName(){
        return player.getName();
    }

    @Override
    public boolean hasPermission(String permission) {
        return player.hasPermission(permission);
    }

}
