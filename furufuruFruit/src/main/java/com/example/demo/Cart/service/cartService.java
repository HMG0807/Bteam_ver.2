package com.example.demo.Cart.service;
// 이순
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.cart;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class cartService {

	private final cartRepository cr;
	
	public cart getcart(Integer cartId) {
		
		// 카트의 키값 가져옴
		Optional<cart> c1 = this.cr.findById(cartId);
		return c1.get();
		
	}
	
	// 가져온 카트 정보를 삭제하는 메서드
	public void delete(cart c) {
		this.cr.delete(c);
		
	}
	
// ?????
//	public int cartDelete(int cartId) {
//		return cartMapper.deleteCart(cartId);
//	}
	
}
