package com.iktpreobuka.elektronskiDnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronskiDnevnik.entities.GradeEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.StudentTeacherSubjectEntity;

public interface GradeRepository extends CrudRepository<GradeEntity, Integer> {

	public List<GradeEntity> findByStudentTeacherSubject(StudentTeacherSubjectEntity stse);
}
