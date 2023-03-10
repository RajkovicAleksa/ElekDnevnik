package com.iktpreobuka.elektronskiDnevnik.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronskiDnevnik.entities.ClassEntity;

public interface ClassRepository extends CrudRepository<ClassEntity, Integer>{

	Boolean existsByClassNumberAndSchoolYear(Integer classNumber, Integer schoolYear);
}
