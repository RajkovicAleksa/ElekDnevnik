package com.iktpreobuka.elektronskiDnevnik.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronskiDnevnik.entities.AdminEntity;

public interface AdminRepository extends CrudRepository<AdminEntity, Integer> {

	Boolean existsByUsername(String username);
	
	AdminEntity findByUsername(String username);

}