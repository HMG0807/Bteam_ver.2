package com.example.demo.Main;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.product;
import com.example.demo.Entity.servicecenterquestion;



	public interface MainRepository extends JpaRepository<product, Integer>{
		Page<product> findAll(Pageable pageable);
	}	
	
	
	
	

