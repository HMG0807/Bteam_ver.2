package com.example.demo.productregist.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Optional;
import java.util.UUID;


import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.product;

import com.example.demo.ServiceCenter.Exception.UserException;
import com.example.demo.productregist.ProductregistRepository;
import com.example.demo.productregist.ProductuserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class productregistService {

	private final ProductuserRepository productrepository;
	private final ProductregistRepository productregistReposiory;
	

	
	public product create(String name,String category,Integer price,Integer amount, String path , String explan, String id) throws UserException {
		
		product pd = new product();
		pd.setName(name);
		pd.setCategory(category);
		pd.setPrice(price);
		pd.setAmount(amount);
		pd.setPath(path);
		pd.setExplan(explan);
		pd.setBuyuser(getBuyuser(id));
		
		this.productregistReposiory.save(pd);
		return pd;
		
	}
	
	
	public buyuser getBuyuser(String id) throws UserException {
	      Optional<buyuser> user = this.productrepository.findById(id);
	      
	      if(user.isPresent()) { 
	         return user.get();
	      } else {
	         throw new UserException("유저 정보가 없습니다.");
	      }
	}
	
	

  
}
	
	

