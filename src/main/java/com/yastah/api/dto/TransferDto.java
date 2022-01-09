package com.yastah.api.dto;

import java.time.LocalDate;

import com.yastah.api.enumeration.TransferType;

import lombok.Data;

@Data
public class TransferDto {
    private LocalDate date;
    private TransferType type;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public TransferType getType() {
        return type;
    }

    public void setType(TransferType type) {
        this.type = type;
    }
}
