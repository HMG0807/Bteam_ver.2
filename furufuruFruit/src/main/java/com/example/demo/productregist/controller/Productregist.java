package com.example.demo.productregist.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.product;
import com.example.demo.ServiceCenter.Exception.UserException;
import com.example.demo.productregist.ProductregistRepository;

import com.example.demo.productregist.Service.productregistService;
import com.example.demo.productregist.form.productCreateForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class Productregist {
	// 만들어둔 productregistService와 productCreateForm를 사용하기 위한 선언
	private final productregistService productservice;

	
	
	@GetMapping("/mypage/Sellmypage")      // url 경로 
	public String productregistration(productCreateForm productcreateform) {
		return "mypage/seleuser_productregist";     // 상품 등록 html 
		
	}
	
	@PostMapping("/mypage/Sellmypage")
	public String signup(@Valid productCreateForm productcreateform, BindingResult bindingResult, Principal principal) throws UserException {
		
		if(bindingResult.hasErrors()) {
			return "mypage/seleuser_productregist";
		}
		
		
		try {
			this.productservice.create(productcreateform.getName(),
									productcreateform.getCategory(),
									productcreateform.getPrice(),
									productcreateform.getAmount(),
									productcreateform.getPath(), 
									productcreateform.getExplan(),
									principal.getName());
									
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("productUploadFailed", "해당하는 상품을 등록할 수 없습니다");
			return "mypage/seleuser_productregist";
		}

		return "redirect:/mypage/seleuser_productregist";
	}
	
	
}
	

