package com.example.demo.productregist;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.product;

// product 엔티티에 대한 CRUD(생성, 읽기, 업데이트, 삭제) 작업을 수행함. 
public interface ProductuserRepository extends JpaRepository<buyuser, Integer> {
	// buyuser 테이블에 있는 id를 가져와 사용하기 위한 작업
	Optional<buyuser> findById(String id);

	
	
}
