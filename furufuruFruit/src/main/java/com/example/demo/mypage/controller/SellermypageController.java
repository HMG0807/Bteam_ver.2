// 남동현 
package com.example.demo.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SellermypageController {
	
	@GetMapping("/mypage/Sellmypage/inquiry")      // 판매자 상품문의 경로 
	public String saleuserinquiry() {
		return "mypage/saleuser_productinquiry_detail";      // 판매자 상품문의 페이지 
		
	}
	
	@GetMapping("/mypage/Sellmypage/updatecheck")    // 판매자 페이지 상품조회/수정 경로 
	public String updatecheck() {                       
		
	return "mypage/seller";      // 판매자 페이지 상품조회/수정 html 파일 
	
	
	}
	
	
	@GetMapping("/mypage/Sellmypage/orderdetail")
	public String saleuserorderdetail() {
		return "mypage/orderinquiry";
				
	}
	
	
	}
	

