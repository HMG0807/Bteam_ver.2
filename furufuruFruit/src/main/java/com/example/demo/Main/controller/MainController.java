package com.example.demo.Main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DetailPage.service.detailpageservice;
import com.example.demo.Entity.product;
import com.example.demo.Main.MainRepository;
import com.example.demo.Main.service.MainService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

	private final MainService ms;
	private final MainRepository mr;
	
	@GetMapping("/main")
	public String main(Model model) {

	
		List<product> Alllist = this.mr.findAll();		
		model.addAttribute("productList", Alllist);
		
		return "/main/main";
		
	}
		

	
}
