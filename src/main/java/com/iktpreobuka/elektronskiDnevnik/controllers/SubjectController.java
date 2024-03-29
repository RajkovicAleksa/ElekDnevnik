package com.iktpreobuka.elektronskiDnevnik.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.elektronskiDnevnik.controllers.error.RESTError;
import com.iktpreobuka.elektronskiDnevnik.entities.dto.SubjectDTO;
import com.iktpreobuka.elektronskiDnevnik.repositories.SubjectRepository;
import com.iktpreobuka.elektronskiDnevnik.services.SubjectService;
import com.iktpreobuka.elektronskiDnevnik.validation.Validation;

@RestController
@RequestMapping(path = "/dnevnik/subject")
public class SubjectController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private SubjectService subjectService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/allSubjects")
	public ResponseEntity<?> getAllSubjects(){
	    logger.info("Retrieving all subjects");
	    return new ResponseEntity<>(subjectRepo.findAll(), HttpStatus.OK);
	}
	
	//@Secured("ROLE_ADMIN")
	@PostMapping( path = "/createSubject")
	public ResponseEntity<?> createSubject(@Valid @RequestBody SubjectDTO subject, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<>(Validation.createErrorMessage(result), HttpStatus.BAD_REQUEST);
		}
		logger.info("Created classroom");
		return new ResponseEntity<>(subjectService.createSubject(subject), HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping(path = "/changeSubject/{subjectId}")
	public ResponseEntity<?> changeSubject(@PathVariable Integer subjectId, @RequestBody SubjectDTO newSubject){
		if(!subjectRepo.existsById(subjectId)) {
			return new ResponseEntity<>(new RESTError(1, "Subject with id:" + subjectId + " doesn't exists."), HttpStatus.NOT_FOUND);
		}
		logger.info("Changed classroom with id:" + subjectId);
		return new ResponseEntity<>(subjectService.changeSubject(subjectId, newSubject), HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping(path = "/deleteSubject/{subjectId}")
	public ResponseEntity<?> deleteSubject(@PathVariable Integer subjectId){
		if(!subjectRepo.existsById(subjectId)) {
			return new ResponseEntity<>(new RESTError(1, "Subject with id:" + subjectId + " doesn't exists."), HttpStatus.NOT_FOUND);
		}
		logger.info("Deleted classroom with id:" + subjectId);
		return new ResponseEntity<>(subjectService.deleteSubject(subjectId), HttpStatus.ACCEPTED);
	}
}