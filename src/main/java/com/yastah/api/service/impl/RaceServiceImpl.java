package com.yastah.api.service.impl;

import java.util.List;

import com.yastah.api.entity.Race;
import com.yastah.api.exception.ResourceNotFoundException;
import com.yastah.api.repository.RaceRepository;
import com.yastah.api.service.RaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceServiceImpl implements RaceService {
    private RaceRepository raceRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public Race saveRace(Race race) {
        return raceRepository.save(race);
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @Override
    public Race getRaceById(Long id) {
        return raceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Race", "Id", id));
    }

    @Override
    public Race updateRace(Race newRace, long id) {
        Race race = raceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Race", "Id", id));

        race.setName(newRace.getName());

        return raceRepository.save(race);
    }

    @Override
    public void deleteRace(long id) {
        raceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Race", "Id", id));

        raceRepository.deleteById(id);
    }
}
