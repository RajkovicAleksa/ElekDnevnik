package com.iktpreobuka.elektronskiDnevnik.services;

import com.iktpreobuka.elektronskiDnevnik.entities.ClassEntity;

public interface ClassService {

	public ClassEntity createClassroom (ClassEntity classroom);
	
	public ClassEntity changeClassroom (Integer classId, ClassEntity classroom);
	
	public ClassEntity deleteClassroom (Integer classId);
}