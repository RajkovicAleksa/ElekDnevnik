package com.iktpreobuka.elektronskiDnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronskiDnevnik.entities.ClassEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.ParentEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

	Boolean existsByUsername(String username);
	
	Boolean existsByAttendingClass(ClassEntity attendingClass);
	
	List<StudentEntity> findByAttendingClass(ClassEntity attendingClass);
	
	List<StudentEntity> findByParent(ParentEntity parent);
	
	StudentEntity findByUsername(String username);
}