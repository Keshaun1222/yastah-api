package com.yastah.api.repository;

import java.util.List;

import com.yastah.api.entity.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    @Query(value = "SELECT * FROM characters WHERE player = :id AND active = true", nativeQuery = true)
    public List<Character> findPlayerActiveCharacters(@Param("id") Long id);

    @Query(value = "SELECT * FROM characters WHERE player = :id", nativeQuery = true)
    public List<Character> findPlayerCharacters(@Param("id") Long id);

    @Query(value = "SELECT * FROM characters WHERE active = true", nativeQuery = true)
    public List<Character> findActiveCharacters();

    @Query(value = "SELECT * FROM characters WHERE active = false", nativeQuery = true)
    public List<Character> findInactiveCharacters();
}
