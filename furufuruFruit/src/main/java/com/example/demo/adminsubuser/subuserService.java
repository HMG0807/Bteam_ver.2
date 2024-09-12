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
	
	public Page<buyuser> getbuyuserList(int page, String kw ){
		
		
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("registerDate"));  // 등록날짜 내림차순 정렬 
		
		
		// PageRequest =  페이징 및 정렬을 처리하기 위한 인터페이스
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
	    return this.subuserRepository.searchByIdOrName(kw, pageable);
	    			
	   
	    
	        	}
		 
		 
		
	


	//모든 글을 조회하는 메소드
	// 엔티티의 리스트 형태로 얻어서 
	public List<buyuser> getList(){
		// qr의 파인드올된 정보를 리스트형태의 question question리스트가 가지게 된다. 
		List<buyuser> userList = subuserRepository.findAll();
		
		return userList;  
		
		
	}




	
	
	}

	


	

