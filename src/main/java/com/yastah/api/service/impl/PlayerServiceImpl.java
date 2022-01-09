package com.yastah.api.service.impl;

import java.util.List;

import com.yastah.api.entity.Player;
import com.yastah.api.exception.ResourceNotFoundException;
import com.yastah.api.repository.PlayerRepository;
import com.yastah.api.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        super();
        this.playerRepository = playerRepository;
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getActivePlayers() {
        return playerRepository.findActive();
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", id));
    }
    
    @Override
    public Player updatePlayer(Player newPlayer, long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", id));

        player.setName(newPlayer.getName());
        player.setStatus(newPlayer.getStatus());
        player.setEnjin(newPlayer.getEnjin());
        player.setColor(newPlayer.getColor());
        player.setTextColor(newPlayer.getTextColor());
        
        return playerRepository.save(player);
    }

    @Override
    public Player removePlayer(long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", id));

        player.setActive(false);

        return playerRepository.save(player);
    }
}
