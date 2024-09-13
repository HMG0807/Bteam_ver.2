package com.example.demo.adminsubuser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.servicecenterquestion;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class subuserService {

	
	
	
	private final SubuserRepository subuserRepository ;
	
	
	 // 페이징과 검색 기능이 포함된 사용자 목록을 반환하는 메서드
	// getbuyuserList란 메서드가 페이징과 정렬이 된 사용자 목록을 반환한다. 
	public Page<buyuser> getbuyuserList(int page, String kw ){
		
		 // 정렬 조건 설정함.
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("registerDate"));  // 등록날짜 내림차순 정렬 
		
		
		 // 페이지 요청 설정: 현재 페이지, 페이지당 항목 수, 정렬 조건
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		
		 // 키워드(kw)와 페이징(pagealbe)을 사용하여 사용자 목록을 조회함. 
	    return this.subuserRepository.searchByIdOrName(kw, pageable);
	    			
	   
	    
	        	}
		 
		 
		
	


		//모든 글을 조회하는 메소드
		// 엔티티의 리스트 형태로 얻어서 
	public List<buyuser> getList(){
		 // getList = 회원가입한 모든 사용자 정보를 리스트 형태로 반환
		List<buyuser> userList = subuserRepository.findAll();
		
		return userList;  
		
		
	}




	
	
	}

	


	

