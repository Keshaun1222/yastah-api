package com.yastah.api.service.impl;

import java.util.List;

import com.yastah.api.entity.Division;
import com.yastah.api.exception.ResourceNotFoundException;
import com.yastah.api.repository.DivisionRepository;
import com.yastah.api.service.DivisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements DivisionService {
    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionServiceImpl(DivisionRepository divisionRepository) {
        super();
        this.divisionRepository = divisionRepository;
    }

    @Override
    public Division saveDivision(Division division) {
        return divisionRepository.save(division);
    }

    @Override
    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    @Override
    public Division getDivisionById(Long id) {
        return divisionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Division", "Id", id));
    }

    @Override
    public Division updateDivision(Division newDivision, long id) {
        Division division = divisionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Division", "Id", id));

        division.setName(newDivision.getName());

        return divisionRepository.save(division);
    }

    @Override
    public Division removeDivision(long id) {
        Division division = divisionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Division", "Id", id));

        division.setActive(false);

        return divisionRepository.save(division);
    }
}
