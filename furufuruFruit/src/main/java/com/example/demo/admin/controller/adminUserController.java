package com.example.demo.admin.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.buyuser;
import com.example.demo.adminsubuser.subuserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class adminUserController {
	
	private final subuserService subuserService;

	
	// 사용자 관리 화면
	// 모든 사용자 목록을 가져와야하는 메서드가 필요함.
	

    // 사용자 관리 화면
	// 회원가입한 모든 유저들의 리스트들 가져오기 
    @GetMapping("/admin/sub_user")                                                              // 예시임 
    public String startSub(Model model, @RequestParam(value="page", defaultValue="0") int page,
    		// 예시
    		  @RequestParam(value = "kw", defaultValue = "") String kw) {
    	
    	
    	List<buyuser> by = this.subuserService.getList();
    	
    	Page<buyuser> paging = this.subuserService.getbuyuserList(page,kw);
    	
    	
    	
    	
    	model.addAttribute("paging", paging);
    	
    	
    	model.addAttribute("kw", kw);
    	
    	
    	
        return "admin/admin_sub_user"; // 뷰 이름 반환
        
        
        
 
        
	}

}













