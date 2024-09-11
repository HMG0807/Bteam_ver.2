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
		
	
	@GetMapping("/searchproduct")	   
	   public String searchProduct(@RequestParam(value ="keyword")String keyword, 
			   @RequestParam(value = "category", defaultValue = "") String category,
			    Model model, product product)
	{
	      List<product> plist = this.cs.search(keyword);
	      List<product> clist = new ArrayList<product>();
//	      int t = 0;
//	      for(int i = 0; i <plist.size(); i++) {
//	    	  if([plist[i].equals(clist[i])) {
//	    		  
//	    	  }
	    	  
//	      }
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
