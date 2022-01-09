package com.yastah.api.service;

import com.yastah.api.dto.TransferDto;
import com.yastah.api.entity.Player;
import com.yastah.api.entity.Transfer;

public interface TransferService {
    Transfer saveTransfer(Transfer transfer);
    Transfer getPlayerTransfer(Player player);
    Transfer updateTransfer(Player player, TransferDto transferDto);
}
