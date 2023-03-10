package com.iktpreobuka.elektronskiDnevnik.services;

import com.iktpreobuka.elektronskiDnevnik.entities.SubjectEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.dto.SubjectDTO;

public interface SubjectService {

	public SubjectEntity createSubject(SubjectDTO newSubject);
	
	public SubjectEntity changeSubject(Integer subjectId, SubjectDTO newSubject);
	
	public SubjectEntity deleteSubject(Integer subjectId);
}