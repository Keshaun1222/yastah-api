package com.yastah.api.controller;

import java.util.List;

import com.yastah.api.entity.Division;
import com.yastah.api.service.DivisionService;

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
@RequestMapping("/api/divisions")
public class DivisionController {
    private DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        super();
        this.divisionService = divisionService;
    }

    @PostMapping
    public ResponseEntity<Division> saveDivision(@RequestBody Division Division) {
        return new ResponseEntity<>(divisionService.saveDivision(Division), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Division> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

    @GetMapping("{id}")
    public ResponseEntity<Division> getDivisionById(@PathVariable Long id) {
        return new ResponseEntity<>(divisionService.getDivisionById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Division> updateDivision(@PathVariable Long id, @RequestBody Division Division){
        return new ResponseEntity<>(divisionService.updateDivision(Division, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Division> removeDivision(@PathVariable Long id) {
        return new ResponseEntity<>(divisionService.removeDivision(id), HttpStatus.OK);
    }
}
