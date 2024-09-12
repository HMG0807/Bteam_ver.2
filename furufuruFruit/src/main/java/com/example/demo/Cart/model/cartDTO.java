package com.example.demo.Cart.model;


import java.util.List;

import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class cartDTO {
	
	private Integer count;
	
	private List<buyuser> buyuserId;
	
	private List<product> productId;
	



}
