package com.example.demo.admin.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/admin/sub_user")
	public String startSub() {
		
		return "admin/admin_sub_user";
	}
	
	@GetMapping("/admin/sub_center")
	public String startSubCenter(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		
		Page<servicecenterquestion> paging = this.ar.getQustionList(page);
		
		model.addAttribute("paging", paging);
		
		return "admin/admin_sub_center";
	}


	@GetMapping("/admin_sub_center_detail")
	public String subCenterdetail() {
	
		return "admin/admin_sub_center_detail";
	}



}