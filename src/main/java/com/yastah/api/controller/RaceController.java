package com.yastah.api.controller;

import java.util.List;

import com.yastah.api.entity.Race;
import com.yastah.api.service.RaceService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    private RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping
    public ResponseEntity<Race> saveRace(@RequestBody Race race) {
        return new ResponseEntity<>(raceService.saveRace(race), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }

    @GetMapping("{id}")
    public ResponseEntity<Race> getRaceById(@PathVariable Long id) {
        return new ResponseEntity<>(raceService.getRaceById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Race> updateRace(@PathVariable Long id, @RequestBody Race newRace){
        return new ResponseEntity<>(raceService.updateRace(newRace, id) , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRace(@PathVariable Long id) {
        raceService.deleteRace(id);

        return new ResponseEntity<>("Class deleted successfully", HttpStatus.OK);
    }
}
