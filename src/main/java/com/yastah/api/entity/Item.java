package com.yastah.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yastah.api.enumeration.itemenum.ItemRarity;
import com.yastah.api.enumeration.itemenum.ItemType;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "item_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType type;

    @Column(name = "item_rarity", nullable = true)
    @Enumerated(EnumType.STRING)
    private ItemRarity rarity;

    @Column(name = "item_desc", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;
}
