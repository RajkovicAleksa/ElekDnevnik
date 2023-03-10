package com.iktpreobuka.elektronskiDnevnik.services;

import com.iktpreobuka.elektronskiDnevnik.entities.ParentEntity;
import com.iktpreobuka.elektronskiDnevnik.entities.dto.ParentDTO;

public interface ParentService {

	public ParentEntity createParent(ParentDTO newParent);
	
	public ParentEntity changeParent(Integer parentId, ParentDTO changeParent);
	
	public ParentEntity deleteParent(Integer parentId);
}