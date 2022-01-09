package com.yastah.api.service.impl;

import java.util.List;

import com.yastah.api.entity.Class;
import com.yastah.api.exception.ResourceNotFoundException;
import com.yastah.api.repository.ClassRepository;
import com.yastah.api.service.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(ClassRepository classRepository) {
        super();
        this.classRepository = classRepository;
    }

	@Override
	public Class saveClass(Class mainClass) {
		return classRepository.save(mainClass);
	}

	@Override
	public List<Class> getAllClasses() {
		return classRepository.findAll();
	}

	@Override
	public Class getClassById(Long id) {
		return classRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", id));
	}
    
    @Override
    public Class updateClass(Class newClass, long id) {
        Class mainClass = classRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", id));

        mainClass.setName(newClass.getName());

        return classRepository.save(mainClass);
    }

    @Override
    public void deleteClass(long id) {
        classRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class", "Id", id));

        classRepository.deleteById(id);
    }
}
