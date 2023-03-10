package com.iktpreobuka.elektronskiDnevnik.services;

import com.iktpreobuka.elektronskiDnevnik.utils.EmailObject;

public interface EmailService {

	void sendSimpleMessage (EmailObject object);
}