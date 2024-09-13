package com.example.demo.Category.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Category.ProductRepository;
import com.example.demo.Category.service.CategoryService;
import com.example.demo.DetailPage.service.detailpageservice;
import com.example.demo.Entity.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class categoryController {
	
	private final CategoryService cs;
	private final ProductRepository pr;
		
	
//	검색 기능 및 카테고리에 특정 상품을 진열하기 위해 사용함, 두 기능은 검색 기능을 공유하고 있음
//	카테고리에 링크를 누를 시, 그 링크의 단어가 검색 되는 방식
	@GetMapping("/searchproduct")	   
	   public String searchProduct(@RequestParam(value ="keyword")String keyword, 
			   @RequestParam(value = "category", defaultValue = "") String category,
			    Model model, product product)
	{
	      List<product> plist = this.cs.search(keyword);
	      List<product> clist = new ArrayList<product>();
	      
//	      모든 상품을 담고 있는 prudut 리스트와 특정 카테고리를 입력 받아야 하는 category 리스트를 비교하여
//	      카테고리가 찾는 것을 프로덕트가 가지고 있을 시, 카테고리에 더해주는 반복, 조건문	      
	      int t = 0;
	      for(int i = 0; i <plist.size(); i++) {
	    	 ;
	    	  if(plist.get(i).getCategory().equals(category)) {
	    		 
	   			clist.add(plist.get(i));  	
	   			
	    	  }
	      	  
	      }
// 카테고리 리스트에 상품이 있다면, 카테고리 2로 뿌린다
// 즉 카테고리 1.html은 메인에 존재하는 검색 기능의 상품을 담는 템플릿이고
// 카테고리 2.html은 카테고리 링크를 눌렀을 때 상품을 진열하는 템플릿이다.
	      if(!clist.isEmpty()) {
	    	  model.addAttribute("category",clist);
	    	  return "/category/category2";
	      }
	      
	      model.addAttribute("productList", plist);
	      
	      return "/category/category";
	   }
	
	
	@GetMapping("/category/{keyword}")
	public String category(Model model,@PathVariable(value ="keyword")String keyword, product product) {

		List<product> plist = this.cs.category(keyword);		
		model.addAttribute("productList", plist);
		return "/category/category";
		
	}
	
	
	
	
}
