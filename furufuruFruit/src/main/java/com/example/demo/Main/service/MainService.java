package com.example.demo.Main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.product;
import com.example.demo.Entity.servicecenterquestion;
import com.example.demo.Main.MainRepository;
import com.example.demo.ServiceCenter.Exception.UserException;

import lombok.RequiredArgsConstructor;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;




@RequiredArgsConstructor
@Service
public class MainService {

	private final MainRepository mr;

	public Page<product> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("productId"));

		Pageable pageable = PageRequest.of(page, 8, Sort.by(sorts));
		
		return this.mr.findAll(pageable);
	}
		
	
	
	
	
	
	
	
	
	
	
}
