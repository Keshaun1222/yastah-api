package com.yastah.api.controller;

import java.util.List;

import com.yastah.api.entity.Class;
import com.yastah.api.service.ClassService;

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
@RequestMapping("/api/classes")
public class ClassController {
    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<Class> saveClass(@RequestBody Class mainClass) {
        return new ResponseEntity<>(classService.saveClass(mainClass), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("{id}")
    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
        return new ResponseEntity<>(classService.getClassById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class newClass){
        return new ResponseEntity<>(classService.updateClass(newClass, id) , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);

        return new ResponseEntity<>("Class deleted successfully", HttpStatus.OK);
    }
}
