package com.example.demo.DetailPage.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.product;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class detailpageservice {
	
	private final detailpageRepository dpR;
	
	public product getproduct(Integer id){

		Optional<product> p1 = this.dpR.findById(id);
			return p1.get();

		
	}

}
