package com.iktpreobuka.elektronskiDnevnik.services;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class FileHandlerImpl implements FileHandler {

	@Override
	public File getLogs() {
		
		String path = "C:\\Users\\38160\\Desktop";
		File log = new File(path);
		
		return log;
	}

}