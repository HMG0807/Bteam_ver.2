package com.example.demo.admin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.servicecenteranswer;
import com.example.demo.Entity.servicecenterquestion;
import com.example.demo.admin.model.servicecenterAnswerRepository;
import com.example.demo.admin.model.servicecenterQuestionRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class adminService {

	private final servicecenterQuestionRepository sqr;
	private final servicecenterAnswerRepository sar;
	
	public Page<servicecenterquestion> getQuestionList(int page, String kw, String kwType){
		
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("questionDate"));

		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		switch(kwType) {
			case "total": return this.sqr.findAllByTitleOrId(kw, pageable);
			case "id": return this.sqr.findAllById(kw, pageable);
			case "title": return this.sqr.findAllByTitle(kw, pageable);
		}
		
		return this.sqr.findAllByTitleOrId(kw, pageable);
		
	}

	public servicecenterquestion getQuestion(Integer id) {
		
		return this.sqr.findById(id).get();
	}

	public void answerCreate(String title, String content, servicecenterquestion question) {
		servicecenteranswer sca = new servicecenteranswer();
		sca.setTitle(title);
		sca.setContents(content);
		sca.setAnswerDate(LocalDateTime.now());
		sca.setServicecenterquestion(question);
		
		this.sar.save(sca);
		
	}

	public void answerDelete(Integer id) {
		this.sar.deleteById(id);
	}

	public servicecenteranswer getAnswer(Integer id) {
		return this.sar.findById(id).get();
	}

	public void answerUpdate(String title, String content, Integer id) {
		
		servicecenteranswer sca = this.sar.findById(id).get();
		
		sca.setTitle(title);
		sca.setContents(content);
		sca.setAnswerDate(LocalDateTime.now());
		
		this.sar.save(sca);
	}
	
	
}
