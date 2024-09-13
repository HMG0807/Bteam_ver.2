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
    // 모든 사용자 목록을 가져와서 페이지와 검색어를 모델에 추가
	// startsub 메서드에서는 Model 객체를 사용하여 view에 데이터를 전달함.
	// @RequestParam을 통해 페이지 번호 그리고 검색어를 받아올 수 있음. 
    @GetMapping("/admin/sub_user")                                                              
    public String startSub(Model model, @RequestParam(value="page", defaultValue="0") int page,
    		
    		  @RequestParam(value = "kw", defaultValue = "") String kw) {
    	
    	 // 사용자 목록을 가져오는 메서드 호출 (리스트 형태)
    	List<buyuser> by = this.subuserService.getList();
    	
    	
    	 // 페이징기능 및 검색 기능이 포함된 사용자 목록을 가져오는 메서드 호출
    	Page<buyuser> paging = this.subuserService.getbuyuserList(page,kw);
    	
    	
    	
    	// Model에 페이징처리된 결과와 검색어를 추가
    	model.addAttribute("paging", paging);
    	
    	
    	model.addAttribute("kw", kw);
    
    	
        return "admin/admin_sub_user"; 
        
        
        
 
        
	}

}













