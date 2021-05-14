package me.bryangaming.spigot.impl;

import me.bryangaming.common.sender.PlayerWrapper;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerWrapperImpl
        extends SenderWrapperImpl
        implements PlayerWrapper {

    private final Player player;

    public PlayerWrapperImpl(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public UUID getUniqueID() {
        return player.getUniqueId();
    }
}
