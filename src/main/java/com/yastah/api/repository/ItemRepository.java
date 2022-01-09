package com.yastah.api.repository;

import java.util.List;

import com.yastah.api.entity.Item;
import com.yastah.api.enumeration.itemenum.ItemType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM items WHERE item_type = :type", nativeQuery = true)
    public List<Item> findItemsByType(@Param("type") ItemType type);
}
