package com.example.demo.Category;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.product;

public interface ProductRepository extends JpaRepository<product, Integer> {
	
	
		List<product> findByNameContaining(String keyword);
		List<product> findByCategoryContaining(String keyword);
		
		 

}
