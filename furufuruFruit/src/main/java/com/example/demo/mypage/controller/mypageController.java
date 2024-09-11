//남동현 
package com.example.demo.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mypageController {

	@GetMapping("/mypage/order") // 주문 내역 페이지 경로 
	public String showOrderPage() {
		return "mypage/customer"; // 주문 내역 HTML 파일 반환 
	}

	@GetMapping("/mypage/inquiry/products") // 상품 문의 페이지
	public String showProductInquiryPage() {
		
	
		
		return "mypage/productinquiry"; // 상품 문의 HTML 파일 반환

						
		
				}
	
	
}


