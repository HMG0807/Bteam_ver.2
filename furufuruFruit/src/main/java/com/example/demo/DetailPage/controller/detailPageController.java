package com.example.demo.DetailPage.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DetailPage.service.detailpageservice;
import com.example.demo.Entity.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class detailPageController {
	
	private final detailpageservice dpR;
	
	@GetMapping(value = "/detailpage/{productId}")
	public String detail(Model model, @PathVariable(value = "productId") Integer productId) {
		product p = this.dpR.getproduct(productId);
		model.addAttribute("product", p);
		
		
		return "detail_page/detailPage";
	}
	
	


}
