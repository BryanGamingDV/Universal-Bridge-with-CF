package me.bryangaming.bungee.player;

import me.bryangaming.common.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.List;

public class ProxiedImpl implements CommandSender {

    private final ProxiedPlayer proxiedPlayer;

    public ProxiedImpl(ProxiedPlayer proxiedPlayer){
        this.proxiedPlayer = proxiedPlayer;

    }

    @Override
    public void sendMessage(String message) {
        proxiedPlayer.sendMessage(TextComponent.fromLegacyText(message));
    }

    @Override
    public void sendMessage(List<String> messages) {
        messages.forEach(message -> proxiedPlayer.sendMessage(TextComponent.fromLegacyText(message)));
    }

    @Override
    public String getName(){
        return proxiedPlayer.getName();
    }

    @Override
    public boolean hasPermission(String permission) {
        return proxiedPlayer.hasPermission(permission);
    }


}
