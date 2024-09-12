package com.example.demo.DetailPage.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Cart.service.cartService;
import com.example.demo.DetailPage.service.detailpageservice;
import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.product;
import com.example.demo.User.Exception.UserException;
import com.example.demo.User.Service.UserService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class detailPageController {
	
	public final UserService ur;
	public final detailpageservice dr;
	public final cartService cr;
	
	@GetMapping(value = "/product/{productId}")
	public String product(Model model, @PathVariable(value = "productId") Integer product_id) {
		
			product p = this.dr.getproduct(product_id);
			model.addAttribute("product", p);
			
			
			return "detail_page/detailPage";
		
		
	}
	

	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/product/{productId}")
	public String addcart(Principal principal, Integer product_id,
			@RequestParam("count") Integer count,
			@PathVariable("buyuser") buyuser buyuserId,
			@PathVariable("product") product productId) throws UserException {
		buyuser buyuser = this.ur.getUser(principal.getName());
		product product = this.dr.getproduct(product_id);
		
		this.cr.addcart(buyuser, product, count);
		return "detail_page/detailPage";
	}
	
	

	

}
