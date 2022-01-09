package com.yastah.api.controller;

import com.yastah.api.dto.TransferDto;
import com.yastah.api.entity.Player;
import com.yastah.api.entity.Transfer;
import com.yastah.api.service.PlayerService;
import com.yastah.api.service.TransferService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    private PlayerService playerService;
    private TransferService transferService;

    public TransferController(PlayerService playerService, TransferService transferService) {
        super();
        this.playerService = playerService;
        this.transferService = transferService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Transfer> getPlayerTransfer(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        return new ResponseEntity<>(transferService.getPlayerTransfer(player), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Transfer> updatePlayerTransfer(@PathVariable Long id, @RequestBody TransferDto transferDto) {
        Player player = playerService.getPlayerById(id);
        return new ResponseEntity<>(transferService.updateTransfer(player, transferDto), HttpStatus.OK);
    }
}
