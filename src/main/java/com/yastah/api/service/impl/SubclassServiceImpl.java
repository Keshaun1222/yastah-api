package com.yastah.api.service.impl;

import java.util.List;

import com.yastah.api.dto.SubclassDto;
import com.yastah.api.entity.Class;
import com.yastah.api.entity.Subclass;
import com.yastah.api.exception.ResourceNotFoundException;
import com.yastah.api.repository.ClassRepository;
import com.yastah.api.repository.SubclassRepository;
import com.yastah.api.service.SubclassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubclassServiceImpl implements SubclassService {
    private ClassRepository classRepository;
    private SubclassRepository subclassRepository;

    @Autowired
    public SubclassServiceImpl(ClassRepository classRepository, SubclassRepository subclassRepository) {
        super();
        this.classRepository = classRepository;
        this.subclassRepository = subclassRepository;
    }

    @Override
    public Subclass saveSubclass(SubclassDto subclassDto) {
        Class mainClass = classRepository.findById(subclassDto.getClassId()).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", subclassDto.getClassId()));
        Subclass subclass = new Subclass();

        subclass.setName(subclassDto.getName());
        subclass.setMainClass(mainClass);

        return subclassRepository.save(subclass);
    }

    @Override
    public List<Subclass> getAllSubclasses() {
        return subclassRepository.findAll();
    }

    @Override
    public List<Subclass> getSubclassesByClass(Long Class) {
        return subclassRepository.findAllByClass(Class);
    }

    @Override
    public Subclass getSubclassById(Long id) {
        return subclassRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subclass", "Id", id));
    }

    @Override
    public Subclass updateSubclass(SubclassDto subclassDto, long id) {
        Class mainClass = classRepository.findById(subclassDto.getClassId()).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", subclassDto.getClassId()));
        Subclass subclass = subclassRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subclass", "Id", id));

        subclass.setName(subclassDto.getName());
        subclass.setMainClass(mainClass);

        return subclassRepository.save(subclass);
    }

    @Override
    public void deleteSubclass(long id) {
        subclassRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subclass", "Id", id));

        subclassRepository.deleteById(id);
    }
}
