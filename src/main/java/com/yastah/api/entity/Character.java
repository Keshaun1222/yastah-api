package com.yastah.api.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yastah.api.enumeration.Side;

import lombok.Data;

@Data
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player", referencedColumnName = "id", nullable = false)
    private Player player;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "side", nullable = false)
    @Enumerated(EnumType.STRING)
    private Side side;

    @Column(name = "exp", nullable = false)
    private int experience;

    @Column(name = "money", nullable = false)
    private int money;

    @ManyToOne
    @JoinColumn(name = "race", referencedColumnName = "id", nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "class_one", referencedColumnName = "id", nullable = false)
    private Class classOne;

    @ManyToOne
    @JoinColumn(name = "subclass_one", referencedColumnName = "id", nullable = true)
    private Subclass subclassOne;

    @ManyToOne
    @JoinColumn(name = "class_two", referencedColumnName = "id", nullable = true)
    private Class classTwo;

    @ManyToOne
    @JoinColumn(name = "subclass_two", referencedColumnName = "id", nullable = true)
    private Subclass subclassTwo;

    @ManyToOne
    @JoinColumn(name = "division", referencedColumnName = "id", nullable = true)
    private Division division;

    @Column(name = "creation_date", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "transfer", nullable = false)
    private boolean transfer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Class getClassOne() {
        return classOne;
    }

    public void setClassOne(Class classOne) {
        this.classOne = classOne;
    }

    public Subclass getSubclassOne() {
        return subclassOne;
    }

    public void setSubclassOne(Subclass subclassOne) {
        this.subclassOne = subclassOne;
    }

    public Class getClassTwo() {
        return classTwo;
    }

    public void setClassTwo(Class classTwo) {
        this.classTwo = classTwo;
    }

    public Subclass getSubclassTwo() {
        return subclassTwo;
    }

    public void setSubclassTwo(Subclass subclassTwo) {
        this.subclassTwo = subclassTwo;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }
}
