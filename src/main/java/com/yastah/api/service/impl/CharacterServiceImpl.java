package com.yastah.api.service.impl;

import java.util.List;

import com.yastah.api.dto.CharacterDto;
import com.yastah.api.entity.Character;
import com.yastah.api.entity.Class;
import com.yastah.api.entity.Division;
import com.yastah.api.entity.Player;
import com.yastah.api.entity.Race;
import com.yastah.api.entity.Subclass;
import com.yastah.api.exception.ResourceNotFoundException;
import com.yastah.api.repository.CharacterRepository;
import com.yastah.api.repository.ClassRepository;
import com.yastah.api.repository.DivisionRepository;
import com.yastah.api.repository.PlayerRepository;
import com.yastah.api.repository.RaceRepository;
import com.yastah.api.repository.SubclassRepository;
import com.yastah.api.service.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
    private PlayerRepository playerRepository;
    private RaceRepository raceRepository;
    private ClassRepository classRepository;
    private SubclassRepository subclassRepository;
    private DivisionRepository divisionRepository;
    private CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(PlayerRepository playerRepository, RaceRepository raceRepository,
            ClassRepository classRepository, SubclassRepository subclassRepository,
            DivisionRepository divisionRepository, CharacterRepository characterRepository) {
        this.playerRepository = playerRepository;
        this.raceRepository = raceRepository;
        this.classRepository = classRepository;
        this.subclassRepository = subclassRepository;
        this.divisionRepository = divisionRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Character saveCharacter(CharacterDto characterDto) {
        Player player = playerRepository.findById(characterDto.getPlayerId()).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", characterDto.getPlayerId()));
        Race race = raceRepository.findById(characterDto.getRaceId()).orElseThrow(() -> new ResourceNotFoundException("Race", "Id", characterDto.getRaceId()));
        Class classOne = classRepository.findById(characterDto.getClassOneId()).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", characterDto.getClassOneId()));
        Subclass subclassOne = characterDto.getSubclassOneId() != null ? subclassRepository.findById(characterDto.getSubclassOneId()).orElseThrow(() -> new ResourceNotFoundException("Subclass", "Id", characterDto.getSubclassOneId())) : null;
        Class classTwo = characterDto.getClassTwoId() != null ? classRepository.findById(characterDto.getClassTwoId()).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", characterDto.getClassTwoId())) : null;
        Subclass subclassTwo = characterDto.getSubclassTwoId() != null ? subclassRepository.findById(characterDto.getSubclassTwoId()).orElseThrow(() -> new ResourceNotFoundException("Subclass", "Id", characterDto.getSubclassTwoId())) : null;
        Division division = characterDto.getDivisionId() != null ? divisionRepository.findById(characterDto.getDivisionId()).orElseThrow(() -> new ResourceNotFoundException("Division", "Id", characterDto.getDivisionId())) : null;

        Character character = new Character();
        character.setPlayer(player);
        character.setName(characterDto.getName());
        character.setSide(characterDto.getSide());
        character.setExperience(characterDto.getExperience());
        character.setMoney(characterDto.getMoney());
        character.setRace(race);
        character.setClassOne(classOne);
        character.setSubclassOne(subclassOne);
        character.setClassTwo(classTwo);
        character.setSubclassTwo(subclassTwo);
        character.setDivision(division);
        character.setDateCreated(characterDto.getDateCreated());
        character.setActive(true);
        character.setTransfer(characterDto.isTransfer());

        return characterRepository.save(character);
    }

    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public List<Character> getPlayerActiveCharacters(Long playerId) {
        return characterRepository.findPlayerActiveCharacters(playerId);
    }

    @Override
    public List<Character> getPlayerCharacters(Long playerId) {
        return characterRepository.findPlayerCharacters(playerId);
    }

    @Override
    public List<Character> getActiveCharacters() {
        return characterRepository.findActiveCharacters();
    }

    @Override
    public List<Character> getInactiveCharacters() {
        return characterRepository.findInactiveCharacters();
    }

    @Override
    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character", "Id", id));
    }

    @Override
    public Character updateCharacter(CharacterDto characterDto, Long id) {
        Player player = playerRepository.findById(characterDto.getPlayerId()).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", characterDto.getPlayerId()));
        Race race = raceRepository.findById(characterDto.getRaceId()).orElseThrow(() -> new ResourceNotFoundException("Race", "Id", characterDto.getRaceId()));
        Class classOne = classRepository.findById(characterDto.getClassOneId()).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", characterDto.getClassOneId()));
        Subclass subclassOne = characterDto.getSubclassOneId() != null ? subclassRepository.findById(characterDto.getSubclassOneId()).orElseThrow(() -> new ResourceNotFoundException("Subclass", "Id", characterDto.getSubclassOneId())) : null;
        Class classTwo = characterDto.getClassTwoId() != null ? classRepository.findById(characterDto.getClassTwoId()).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", characterDto.getClassTwoId())) : null;
        Subclass subclassTwo = characterDto.getSubclassTwoId() != null ? subclassRepository.findById(characterDto.getSubclassTwoId()).orElseThrow(() -> new ResourceNotFoundException("Subclass", "Id", characterDto.getSubclassTwoId())) : null;
        Division division = characterDto.getDivisionId() != null ? divisionRepository.findById(characterDto.getDivisionId()).orElseThrow(() -> new ResourceNotFoundException("Division", "Id", characterDto.getDivisionId())) : null;

        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character", "Id", id));
        character.setPlayer(player);
        character.setName(characterDto.getName());
        character.setSide(characterDto.getSide());
        character.setExperience(characterDto.getExperience());
        character.setMoney(characterDto.getMoney());
        character.setRace(race);
        character.setClassOne(classOne);
        character.setSubclassOne(subclassOne);
        character.setClassTwo(classTwo);
        character.setSubclassTwo(subclassTwo);
        character.setDivision(division);
        character.setDateCreated(characterDto.getDateCreated());
        character.setTransfer(characterDto.isTransfer());

        return characterRepository.save(character);
    }

    @Override
    public Character removeCharacter(Long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character", "Id", id));
        
        character.setActive(false);

        return characterRepository.save(character);
    }
    
}
