package com.yastah.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yastah.api.enumeration.DM;

import lombok.Data;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dm", nullable = false)
    @Enumerated(EnumType.STRING)
    private DM status;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "enjin", nullable = false)
    private String enjin;

    @Column(name = "color", nullable = true)
    private String color;

    @Column(name = "text_color", nullable = true)
    private String textColor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DM getStatus() {
        return status;
    }

    public void setStatus(DM status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEnjin() {
        return enjin;
    }

    public void setEnjin(String enjin) {
        this.enjin = enjin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
}
