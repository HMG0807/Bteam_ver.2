package com.example.demo.Cart.service;
import java.util.List;
// 이순
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.cart;
import com.example.demo.Entity.product;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class cartService {

	private final cartRepository cr;
	
	public cart getcart(buyuser buyuserId) {
		
		// 카트의 키값 가져옴
		Optional<cart> c1 = this.cr.findById(null);
		return c1.get();
		
	}
	
	public cart getcart(Integer count) {
		
		List<cart> c1 = this.cr.findByCount(count);
		return c1.get(count);
	}
	
	// 가져온 카트 정보를 삭제하는 메서드
	public void delete(cart c) {
		this.cr.delete(c);
		
	}
	
	/////// 위는 예전거 / 아래는 현재 /////////
	
	
	
	// 카트에 정보를 더함
	public void addcart(buyuser buyuserId, product productId, Integer count) {
		
		// 유저의 키값, 상품 키값, 수량을 저장함
		cart c = new cart();
		c.setBuyuser(buyuserId);
		c.setProduct(productId);
		c.setCount(count);

		
		this.cr.save(c);
		
	}
	
//	public cart getcart(buyuser buyuserId, product productId, Integer count) {
//		 
//		
//		List<cart> c1 = this.cr.findAll();
//		return c1.get(count);
//		
//	}
	
	

	
}
