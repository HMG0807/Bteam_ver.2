package com.example.demo.Cart.controller;
// 이순
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DetailPage.service.detailpageservice;
import com.example.demo.Cart.service.cartService;
import com.example.demo.Entity.cart;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Controller
public class cartController {
	
	private final cartService cr;
	private final detailpageservice dpR;
	
	// 카트로 접근하면 DB 정보를 가져와서 추가함
	@GetMapping(value = "/cart/{cartId}")
	public String cart(Model model,
			@PathVariable(value = "cartId") Integer cartId) {
		cart c = this.cr.getcart(cartId);
		System.out.println(c.getCartId());
		model.addAttribute("cart", c);
		return "cart/cart";
	}
	
	// 해당 주소로 접근하면 카트의 아이디를 가져와서 삭제하고 카트로 리다이렉트
	@GetMapping(value = "/cart/delete/{cartId}")
	public String cartDelete(@PathVariable(value = "cartId") Integer cartId){
		cart c = this.cr.getcart(cartId);
		this.cr.delete(c);
		return "redirect:/main";
	}

	

}
