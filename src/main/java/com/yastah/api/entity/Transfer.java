package com.yastah.api.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "transfers")
public class Transfer implements Serializable {
    
    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Player player;

    @Column(name = "live_brinmore")
    private LocalDate brinmoreLiveTransfer;

    @Column(name = "death_brinmore")
    private LocalDate brinmoreDeathTransfer;

    @Column(name = "live_drimus")
    private LocalDate dirmusLiveTransfer;

    @Column(name = "death_dirmus")
    private LocalDate dirmusDeathTransfer;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDate getBrinmoreLiveTransfer() {
        return brinmoreLiveTransfer;
    }

    public void setBrinmoreLiveTransfer(LocalDate brinmoreLiveTransfer) {
        this.brinmoreLiveTransfer = brinmoreLiveTransfer;
    }

    public LocalDate getBrinmoreDeathTransfer() {
        return brinmoreDeathTransfer;
    }

    public void setBrinmoreDeathTransfer(LocalDate brinmoreDeathTransfer) {
        this.brinmoreDeathTransfer = brinmoreDeathTransfer;
    }

    public LocalDate getDirmusLiveTransfer() {
        return dirmusLiveTransfer;
    }

    public void setDirmusLiveTransfer(LocalDate dirmusLiveTransfer) {
        this.dirmusLiveTransfer = dirmusLiveTransfer;
    }

    public LocalDate getDirmusDeathTransfer() {
        return dirmusDeathTransfer;
    }

    public void setDirmusDeathTransfer(LocalDate dirmusDeathTransfer) {
        this.dirmusDeathTransfer = dirmusDeathTransfer;
    }
}
