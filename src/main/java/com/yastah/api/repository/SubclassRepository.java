package com.yastah.api.repository;

import java.util.List;

import com.yastah.api.entity.Subclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubclassRepository extends JpaRepository<Subclass, Long> {
    @Query(value = "SELECT * FROM subclasses WHERE class = :id", nativeQuery = true)
    public List<Subclass> findAllByClass(@Param("id") Long id);
}
