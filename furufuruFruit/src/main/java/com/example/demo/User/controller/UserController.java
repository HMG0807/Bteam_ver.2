package com.example.demo.User.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.User.Service.UserService;
import com.example.demo.User.form.UserCreateForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login/login_form";
	}
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup/signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		System.out.println(userCreateForm.getEmail1());
		System.out.println(userCreateForm.getEmail2());
		if(bindingResult.hasErrors()) {
			return "signup/signup_form";
		}
		
		// == vs equals 차이점?
		if(!userCreateForm.getPw().equals(userCreateForm.getPw2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect",
					"패스워드가 일치하지 않습니다.");
			return "signup/signup_form";
		}
		
		try {
			this.userService.create(userCreateForm.getId(),
									userCreateForm.getPw(),
									userCreateForm.getEmail1(),
									userCreateForm.getEmail2(),
									userCreateForm.getName(), 
									userCreateForm.getTell(),
									userCreateForm.getAddress1(),
									userCreateForm.getAddress2(),
									userCreateForm.getAddress3(),
									userCreateForm.getGender(),
									userCreateForm.getRole());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "signup/signup_form";
		}

		return "redirect:/main";
	}
	
}
