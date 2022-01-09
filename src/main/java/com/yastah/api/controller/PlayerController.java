package com.yastah.api.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.yastah.api.entity.Player;
import com.yastah.api.entity.Transfer;
import com.yastah.api.service.PlayerService;
import com.yastah.api.service.TransferService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private PlayerService playerService;
    private TransferService transferService;

    public PlayerController(PlayerService playerService, TransferService transferService) {
        super();
        this.playerService = playerService;
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
        Player newPlayer = playerService.savePlayer(player);
        LocalDate now = LocalDate.now(ZoneId.of("America/New_York"));
        Transfer transfer = new Transfer();
        
        transfer.setPlayer(newPlayer);
        transfer.setBrinmoreLiveTransfer(now);
        transfer.setBrinmoreDeathTransfer(now);
        transfer.setDirmusLiveTransfer(now);
        transfer.setDirmusDeathTransfer(now);

        transferService.saveTransfer(transfer);

        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/active")
    public List<Player> getActivePlayers() {
        return playerService.getActivePlayers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.getPlayerById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player){
        return new ResponseEntity<>(playerService.updatePlayer(player, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Player> removePlayer(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.removePlayer(id), HttpStatus.OK);
    }
}
