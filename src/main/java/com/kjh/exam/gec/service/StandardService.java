package com.kjh.exam.gec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.exam.gec.repository.StandardRepository;

@Service
public class StandardService {
	private StandardRepository standardRepository;

	@Autowired
	public StandardService(StandardRepository standardRepository) {
		this.standardRepository = standardRepository;
	}
	
	
}
