package me.bryangaming.bungee.impl;

import me.bryangaming.common.sender.PlayerWrapper;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

public class ProxiedPlayerImpl extends ProxiedSenderImpl implements PlayerWrapper {

    private ProxiedPlayer proxiedPlayer;

    public ProxiedPlayerImpl(ProxiedPlayer player){
        super(player);
        this.proxiedPlayer = player;

    }

    @Override
    public UUID getUniqueID() {
        return proxiedPlayer.getUniqueId();
    }
}
