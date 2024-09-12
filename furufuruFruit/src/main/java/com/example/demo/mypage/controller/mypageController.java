//남동현 
package com.example.demo.mypage.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.ServiceCenter.Exception.UserException;
import com.example.demo.ServiceCenter.Service.QuestionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class mypageController {
	
	private final QuestionService qs;

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage/order") // 주문 내역 페이지 경로 
	public String showOrderPage(Model model, Principal principal) throws UserException  {
		
		
		
		model.addAttribute("user", qs.getBuyuser(principal.getName()));
		
		return "mypage/customer"; // 주문 내역 HTML 파일 반환 
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage/inquiry/products") // 상품 문의 페이지
	public String showProductInquiryPage() {
		
	
		
		return "mypage/productinquiry"; // 상품 문의 HTML 파일 반환

						
		
				}
	
	
}


