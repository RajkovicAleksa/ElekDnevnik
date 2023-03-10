package com.iktpreobuka.elektronskiDnevnik.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.elektronskiDnevnik.entities.SubjectEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.dto.SubjectDTO;
import com.iktpreobuka.elektronskiDnevnik.repositories.SubjectRepository;
import com.iktpreobuka.elektronskiDnevnik.validation.Validation;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepo;
	
	@Override
	public SubjectEntity createSubject(SubjectDTO newSubject) {
		SubjectEntity subject = new SubjectEntity();
		subject.setName(newSubject.getName());
		subject.setWeeklyFond(newSubject.getWeeklyFond());
		subject.setActive(true);
		return subjectRepo.save(subject);
	}

	@Override
	public SubjectEntity changeSubject(Integer subjectId, SubjectDTO newSubject) {
		if(!subjectRepo.existsById(subjectId)) {
			return null;
		}
		SubjectEntity subject = subjectRepo.findById(subjectId).get();
		subject.setName(Validation.setIfNotNull(subject.getName(), newSubject.getName()));
		subject.setWeeklyFond(Validation.setIfNotNull(subject.getWeeklyFond(), newSubject.getWeeklyFond()));
		return subjectRepo.save(subject);
	}

	@Override
	public SubjectEntity deleteSubject(Integer subjectId) {
		if(!subjectRepo.existsById(subjectId)) {
			return null;
		}
		SubjectEntity subject = subjectRepo.findById(subjectId).get();
		if(subject.isActive()) {
			subject.setActive(false);
			return subjectRepo.save(subject);
		}
		return null;
	}

}