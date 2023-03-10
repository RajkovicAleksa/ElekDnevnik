package com.iktpreobuka.elektronskiDnevnik.services;

import com.iktpreobuka.elektronskiDnevnik.entities.StudentEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.StudentTeacherSubjectEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.dto.StudentDTO;

public interface StudentService {

	public StudentEntity createStudent(StudentDTO newStudent, Integer parentId, Integer classId);
	
	public StudentEntity changeStudent(Integer studentId, StudentDTO newStudent);
	
	public StudentEntity changeClassroomForStudent(Integer studentId, Integer classId);
	
	public StudentEntity deleteStudent(Integer studentId);
	
	public StudentTeacherSubjectEntity addTeacherAndSubjectToStudent(Integer studentId, Integer teacherId, 
																	 Integer subjectId);
}