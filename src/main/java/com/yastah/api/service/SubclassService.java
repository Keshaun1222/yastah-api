package com.yastah.api.service;

import java.util.List;

import com.yastah.api.dto.SubclassDto;
import com.yastah.api.entity.Subclass;

public interface SubclassService {
    Subclass saveSubclass(SubclassDto subclassdto);
    List<Subclass> getAllSubclasses();
    List<Subclass> getSubclassesByClass(Long Class);
    Subclass getSubclassById(Long id);
    Subclass updateSubclass(SubclassDto subclassDto, long id);
    void deleteSubclass(long id);
}
