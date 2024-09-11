package com.example.demo.Category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Category.ProductRepository;
import com.example.demo.Entity.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {

	private final ProductRepository pr;
	
	public List<product> search(String keyword){
	      return this.pr.findByNameContaining(keyword);
	   }
	
	public List<product> category(String keyword){
		return this.pr.findByCategoryContaining(keyword);
		
	}
	
	
	
	
	
	
	
}
