package com.yastah.api.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.yastah.api.enumeration.Side;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class CharacterDto {
    private Long playerId;
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Side side;

    private int experience;
    private int money;
    private Long raceId;
    private Long classOneId;
    private Long subclassOneId;
    private Long classTwoId;
    private Long subclassTwoId;
    private Long divisionId;
    
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dateCreated;

    private boolean transfer;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
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

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Long getClassOneId() {
        return classOneId;
    }

    public void setClassOneId(Long classOneId) {
        this.classOneId = classOneId;
    }

    public Long getSubclassOneId() {
        return subclassOneId;
    }

    public void setSubclassOneId(Long subclassOneId) {
        this.subclassOneId = subclassOneId;
    }

    public Long getClassTwoId() {
        return classTwoId;
    }

    public void setClassTwoId(Long classTwoId) {
        this.classTwoId = classTwoId;
    }

    public Long getSubclassTwoId() {
        return subclassTwoId;
    }

    public void setSubclassTwoId(Long subclassTwoId) {
        this.subclassTwoId = subclassTwoId;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }
}
