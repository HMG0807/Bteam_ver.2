package com.example.demo.Cart.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.cart;


public interface cartRepository extends JpaRepository<cart, Integer> {
	
	// 키값으로 조회하니 한 줄을 통으로 들고옴
	List<cart> findByCartId(Integer cartId);

}
