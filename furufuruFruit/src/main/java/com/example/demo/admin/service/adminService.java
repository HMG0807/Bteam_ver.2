package com.example.demo.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.servicecenterquestion;
import com.example.demo.admin.model.servicecenterQuestionRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class adminService {

	private final servicecenterQuestionRepository ar;
	
	public Page<servicecenterquestion> getQustionList(int page){
		
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("questionDate"));

		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return this.ar.findAll(pageable);
	}
	
	
}
