package com.example.demo.Cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.cart;
import com.example.demo.Entity.product;


public interface cartRepository extends JpaRepository<cart, Integer> {
	
	// 키값으로 조회하니 한 줄을 통으로 들고옴
	List<cart> findByCartId(Integer cartId);
	List<cart> findByBuyuser(buyuser buyuser);
//	Optional<cart> findAll(buyuser buyuserId, product productId, Integer count);
//	Optional<cart> findById(buyuser buyuserId);
	List<cart> findByCount(Integer count);

}
