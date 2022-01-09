package com.yastah.api.service;

import java.util.List;

import com.yastah.api.entity.Class;

public interface ClassService {
    Class saveClass(Class mainClass);
    List<Class> getAllClasses();
    Class getClassById(Long id);
    Class updateClass(Class newClass, long id);
    void deleteClass(long id);
}
