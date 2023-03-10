package com.iktpreobuka.elektronskiDnevnik.services;

import java.util.List;

import com.iktpreobuka.elektronskiDnevnik.entities.SubjectEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.TeacherEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.TeacherSubjectEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.dto.TeacherDTO;

public interface TeacherService {

	public TeacherEntity createTeacher(TeacherDTO newTeacher);
	
	public TeacherEntity changeTeacher(Integer teacherId, TeacherDTO newTeacher);
	
	public TeacherEntity deleteTeacher(Integer teacherId);
	
	public TeacherSubjectEntity addSubjectForTeacher(Integer teacherId, Integer subjectId);
	
	public List<SubjectEntity> getAllSubjetcsByTeacher(Integer teacherId);
	
	public List<SubjectEntity> getAllSubjetcsByTeacher(); 
}