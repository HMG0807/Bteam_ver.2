package com.example.demo.Cart.controller;
import org.springframework.security.access.prepost.PreAuthorize;
// 이순
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DetailPage.service.detailpageservice;
import com.example.demo.Cart.service.cartService;
import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.cart;
import com.example.demo.Entity.product;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Controller
public class cartController {
//	
	private final cartService cr;
	private final detailpageservice dr;
//	
//	// 카트로 접근하면 DB 정보를 가져와서 추가함
//	@GetMapping(value = "/cart")
//	public String cart(Model model,
//			@PathVariable(value = "cartId") Integer cartId) {
//		cart c = this.cr.getcart(cartId);
//		System.out.println(c.getCartId());
//		model.addAttribute("cart", c);
//		return "cart/cart";
//	}
//	
//	// 해당 주소로 접근하면 카트의 아이디를 가져와서 삭제하고 카트로 리다이렉트
//	@GetMapping(value = "/cart/delete/{cartId}")
//	public String cartDelete(@PathVariable(value = "cartId") Integer cartId){
//		cart c = this.cr.getcart(cartId);
//		this.cr.delete(c);
//		return "redirect:/main";
//	}
	
	// 로그인 안하면 접근 불가
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/cart/{buyuserId}")
	public String cart() {
	
		return "/cart/cart";
	}
	

	// 장바구니에 물품 추가 시도 -> 오류때문에 중단
	// 로그인 안하면 접근 불가
//	@PreAuthorize("isAuthenticated()")
//	@GetMapping(value = "/cart/{buyuserId}")
//	public String cart(Model model, 
//							@PathVariable(value="buyuserId") buyuser buyuserId,
//							@RequestParam(value="count") Integer count) {
//		
//		cart c = this.cr.getcart(buyuserId);
//		model.addAttribute("cart", c);
//		
//		
//		return "/cart/cart";
//	}
	
	

	

}
