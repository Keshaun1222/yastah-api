package com.yastah.api.service;

import java.util.List;

import com.yastah.api.entity.Player;

public interface PlayerService {
    Player savePlayer(Player player);
    List<Player> getAllPlayers();
    List<Player> getActivePlayers();
    Player getPlayerById(Long id);
    Player updatePlayer(Player newPlayer, long id);
    Player removePlayer(long id);
}
