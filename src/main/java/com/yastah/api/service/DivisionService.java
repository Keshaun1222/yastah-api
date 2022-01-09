package com.yastah.api.service;

import java.util.List;

import com.yastah.api.entity.Division;

public interface DivisionService {
    Division saveDivision(Division division);
    List<Division> getAllDivisions();
    Division getDivisionById(Long id);
    Division updateDivision(Division newDivision, long id);
    Division removeDivision(long id);
}
