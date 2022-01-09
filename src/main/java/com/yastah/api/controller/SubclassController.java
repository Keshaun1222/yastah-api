package com.yastah.api.controller;

import java.util.List;

import com.yastah.api.dto.SubclassDto;
import com.yastah.api.entity.Subclass;
import com.yastah.api.service.SubclassService;

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
@RequestMapping("/api/subclasses")
public class SubclassController {
    private SubclassService subclassService;

    public SubclassController(SubclassService subclassService) {
        this.subclassService = subclassService;
    }

    @PostMapping
    public ResponseEntity<Subclass> saveSubclass(@RequestBody SubclassDto subclassDto) {
        return new ResponseEntity<>(subclassService.saveSubclass(subclassDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Subclass> getAllSubclasses() {
        return subclassService.getAllSubclasses();
    }

    @GetMapping("/classes/{id}")
    public List<Subclass> getAllByClass(@PathVariable Long id) {
        return subclassService.getSubclassesByClass(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Subclass> getPlayerById(@PathVariable Long id) {
        return new ResponseEntity<>(subclassService.getSubclassById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Subclass> updateSubclass(@PathVariable Long id, @RequestBody SubclassDto subclassDto) {
        return new ResponseEntity<>(subclassService.updateSubclass(subclassDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubclass(@PathVariable Long id) {
        subclassService.deleteSubclass(id);

        return new ResponseEntity<>("Subclass deleted successfully", HttpStatus.OK);
    }
}
