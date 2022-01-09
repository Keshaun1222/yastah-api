package com.yastah.api.controller;

import java.util.List;

import com.yastah.api.dto.CharacterDto;
import com.yastah.api.entity.Character;
import com.yastah.api.service.CharacterService;

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
@RequestMapping("/api/characters")
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        super();
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<Character> saveCharacter(@RequestBody CharacterDto characterDto) {
        return new ResponseEntity<>(characterService.saveCharacter(characterDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/player/active/{id}")
    public List<Character> getPlayerActiveCharacters(@PathVariable Long id) {
        return characterService.getPlayerActiveCharacters(id);
    }

    @GetMapping("/player/{id}")
    public List<Character> getPlayerCharacters(@PathVariable Long id) {
        return characterService.getPlayerActiveCharacters(id);
    }

    @GetMapping("/active")
    public List<Character> getActiveCharacters() {
        return characterService.getActiveCharacters();
    }

    @GetMapping("/inactive")
    public List<Character> getInactiveCharacters() {
        return characterService.getInactiveCharacters();
    }

    @GetMapping("{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        return new ResponseEntity<>(characterService.getCharacterById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody CharacterDto characterDto) {
        return new ResponseEntity<>(characterService.updateCharacter(characterDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Character> removePlayer(@PathVariable Long id) {
        return new ResponseEntity<>(characterService.removeCharacter(id), HttpStatus.OK);
    }
}
