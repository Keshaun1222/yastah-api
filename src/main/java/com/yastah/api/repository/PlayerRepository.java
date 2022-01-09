package com.yastah.api.repository;

import java.util.List;

import com.yastah.api.entity.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value = "SELECT * FROM players WHERE active = true", nativeQuery = true)
    public List<Player> findActive();
}
