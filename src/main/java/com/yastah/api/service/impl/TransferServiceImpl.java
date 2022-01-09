package com.yastah.api.service.impl;

import com.yastah.api.dto.TransferDto;
import com.yastah.api.entity.Player;
import com.yastah.api.entity.Transfer;
import com.yastah.api.exception.ResourceNotFoundException;
import com.yastah.api.repository.TransferRepository;
import com.yastah.api.service.TransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private TransferRepository transferRepository;

    @Autowired
    public TransferServiceImpl(TransferRepository transferRepository) {
        super();
        this.transferRepository = transferRepository;
    }

    @Override
    public Transfer saveTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer getPlayerTransfer(Player player) {
        return transferRepository.findById(player.getId()).orElseThrow(() -> new ResourceNotFoundException("Transfer", "Player", player.getId()));
    }

    @Override
    public Transfer updateTransfer(Player player, TransferDto transferDto) {
        Transfer transfer = transferRepository.findById(player.getId()).orElseThrow(() -> new ResourceNotFoundException("Transfer", "Player", player.getId()));

        switch(transferDto.getType()) {
            case BRINMORE_LIVE:
                transfer.setBrinmoreLiveTransfer(transferDto.getDate());
                break;
            case BRINMORE_DEATH:
                transfer.setBrinmoreDeathTransfer(transferDto.getDate());
                break;
            case DIRMUS_LIVE:
                transfer.setDirmusLiveTransfer(transferDto.getDate());
                break;
            case DIRMUS_DEATH:
                transfer.setDirmusDeathTransfer(transferDto.getDate());
                break;
        }

        return transferRepository.save(transfer);
    }
    
    
}
