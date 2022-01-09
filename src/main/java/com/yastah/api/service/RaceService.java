package com.yastah.api.service;

import java.util.List;

import com.yastah.api.entity.Race;

public interface RaceService {
    Race saveRace(Race race);
    List<Race> getAllRaces();
    Race getRaceById(Long id);
    Race updateRace(Race newRace, long id);
    void deleteRace(long id);
}
