package com.yastah.api.repository;

import com.yastah.api.entity.Transfer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    
}
