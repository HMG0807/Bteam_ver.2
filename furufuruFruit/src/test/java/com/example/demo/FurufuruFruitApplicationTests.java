package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.product;
import com.example.demo.Entity.servicecenterquestion;
import com.example.demo.admin.model.servicecenterQuestionRepository;
// 이순

@SpringBootTest
class FurufuruFruitApplicationTests {

	@Autowired
	private servicecenterQuestionRepository ar;
	
	@Test
	void contextLoads() {
		
		List<servicecenterquestion> questionList = this.ar.findAll();
		
		System.out.println(questionList.toString());
		
		
//		product p1 = new product();
//		p1.setName("[수제케이크]솔크라서 군침이 싹도노");
//		p1.setPrice(9724);
//		p1.setExplan("크롱한테 먹여보고 검증 받은 맛!");
//		
		// 판매자는 나중에 연결
		
	}

}
