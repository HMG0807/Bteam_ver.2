package com.example.demo.DetailPage.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Cart.service.cartRepository;
import com.example.demo.Entity.cart;
import com.example.demo.Entity.product;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class detailpageservice {
	
	private final detailpageRepository dr;
	private final cartRepository cr;
	
	public product getproduct(Integer id){

		Optional<product> p1 = this.dr.findById(id);
			return p1.get();

		
	}

	public void addcart(Integer count) {
		
		cart c = new cart();
		c.setCount(count);

		
		this.cr.save(c);
		
	}
	
	


}
