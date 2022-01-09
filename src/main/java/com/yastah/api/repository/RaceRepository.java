package com.yastah.api.repository;

import com.yastah.api.entity.Race;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
    
}
