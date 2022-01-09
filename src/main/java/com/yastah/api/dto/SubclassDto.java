package com.yastah.api.dto;

import lombok.Data;

@Data
public class SubclassDto {
    private String name;
    private long classId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }
}
