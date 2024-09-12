package com.example.demo.admin.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.servicecenteranswer;
import com.example.demo.Entity.servicecenterquestion;
import com.example.demo.admin.service.adminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class adminController {
	
	private final adminService ar;


	@GetMapping("/master")
	public String start() {
		 
		return "admin/admin_main";
	}
	

	
	@GetMapping("/admin/sub_center")
	public String startSubCenter(Model model, @RequestParam(value="page", defaultValue="0") int page,
								@RequestParam(value="kw", defaultValue="") String kw,
								@RequestParam(value="kwType", defaultValue="") String kwType) {
		
		Page<servicecenterquestion> paging = this.ar.getQuestionList(page, kw, kwType);
		
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
		model.addAttribute("kwType", kwType);
		
		return "admin/admin_sub_center";
	}


	@GetMapping("/admin/sub_center_detail/{id}")
	public String subCenterdetail(Model model, @PathVariable("id") Integer id) {
		
		servicecenterquestion scQuestion = this.ar.getQuestion(id);
		
		model.addAttribute("scQuestion", scQuestion);
		
		if(scQuestion.getServicecenteranswer() == null) {
			//답변이 등록되어 있지 않을 때
			return "admin/admin_sub_center_detail";
			
		} else {
			//답변이 등록되어 있을 때
			return "admin/admin_sub_center_answer_detail";
		}
		
	}
	
	@PostMapping("/admin/sub_center_answer")
	public String subAnswerCreate(@RequestParam(value="title", defaultValue="0") String title,
								@RequestParam(value="content", defaultValue="0") String content,
								@RequestParam(value="questionId", defaultValue="0") Integer questionId) {
		
		this.ar.answerCreate(title, content, this.ar.getQuestion(questionId));
		
		return "redirect:/admin/sub_center";
	}
	
	@GetMapping("/admin/sub_center_answer/update/{id}")
	public String subCenterAnswerUpdate(@PathVariable("id") Integer id,
										@RequestParam(value="title", defaultValue="0") String title,
										@RequestParam(value="content", defaultValue="0") String content) {

		servicecenteranswer scAnswer = this.ar.getAnswer(id); //id에 해당하는 답변 객체 가져오기
		
		this.ar.answerUpdate(title, content, id); //수정하기
		
		return "redirect:/admin/sub_center_detail/" + scAnswer.getServicecenterquestion().getCquestionId();
	}
	
	@GetMapping("/admin/sub_center_answer/delete/{id}")
	public String subCenterAnswerDelete(@PathVariable("id") Integer id) {

		servicecenteranswer scAnswer = this.ar.getAnswer(id); //id에 해당하는 답변 객체 가져오기
		
		this.ar.answerDelete(id); //삭제하기
		
		return "redirect:/admin/sub_center_detail/" + scAnswer.getServicecenterquestion().getCquestionId();
	}


}











