package com.iktpreobuka.elektronskiDnevnik.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.elektronskiDnevnik.entities.dto.TeacherDTO;
import com.iktpreobuka.elektronskiDnevnik.repositories.UserRepository;

@Component
public class TeacherCustomValidator implements Validator{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return TeacherDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TeacherDTO teacher = (TeacherDTO) target;
		if(!teacher.getPassword().equals(teacher.getRepetedPass())) {
			errors.reject("400", "Password must match.");
		}else if(userRepo.existsByUsername(teacher.getUsername())) {
			errors.reject("400", "Username already exists.");
		}
		
	}

}