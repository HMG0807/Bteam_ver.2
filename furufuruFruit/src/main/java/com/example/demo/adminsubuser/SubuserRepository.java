package com.example.demo.adminsubuser;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.buyuser;

public interface SubuserRepository extends JpaRepository<buyuser, Integer> {
	 Optional<buyuser> findById(Integer id);
	
	 
	 
	 	//@Query 쿼리는 buyuser 엔티티에서 (id, name) keyword가 포함된 행,레코드,튜플 찾음. 
	 	// b 는 buyuser의 약자. 
	 	// Id or 이름으로 사용자를 검색하는 쿼리임. 
	  	@Query("SELECT b FROM buyuser b WHERE b.id LIKE %:kw% OR b.name LIKE %:kw%")
	  
	  				// 쿼리 결과를 페이징 처리된 결과로 반환.
	  		// searchByIdOrName = keyword, pageable 파라미터 값 받음. 
	    Page<buyuser> searchByIdOrName(@Param("kw") String keyword, Pageable pageable);
	    
	    // keyword가 쿼리의 :keyword 파라미터에 매핑됨을 나타냄. 
	}
	 
	 

