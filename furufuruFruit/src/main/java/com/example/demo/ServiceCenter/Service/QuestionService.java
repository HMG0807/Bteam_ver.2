package com.example.demo.ServiceCenter.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.buyuser;
import com.example.demo.Entity.servicecenterquestion;
import com.example.demo.ServiceCenter.QuestionRepository;
import com.example.demo.ServiceCenter.QuestionUserRepository;
import com.example.demo.ServiceCenter.Exception.UserException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository qr;
	private final QuestionUserRepository userRepository;

	//로그인한 유저의 모든 고객센터 문의글을 조회하는 메소드
	public Page<servicecenterquestion> getList(int page, String id)  throws UserException {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("questionDate"));

		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return this.qr.findByBuyuser(getBuyuser(id), pageable);
	}
	
	public servicecenterquestion getQuestion(Integer id) throws UserException {
		Optional<servicecenterquestion> q1 = this.qr.findById(id);
		if(q1.isPresent()) {
			return q1.get();
		}else {
			throw new UserException("데이터를 찾을수 없습니다");
		}
	}

	public void create(String subject, String content, String id) throws UserException {
		servicecenterquestion q = new servicecenterquestion();
		q.setTitle(subject);
		q.setContents(content);
		q.setQuestionDate(LocalDateTime.now());
		q.setBuyuser(getBuyuser(id));
		this.qr.save(q);
	}

	public void modify(servicecenterquestion q, String title, String contents) {
		q.setTitle(title);
		q.setContents(contents);
		this.qr.save(q);
	}

	public void delete(servicecenterquestion q) {
		this.qr.delete(q);
	}
	
	//유저 정보 가져오기
	public buyuser getBuyuser(String id) throws UserException {
		Optional<buyuser> user = this.userRepository.findById(id);
		
		if(user.isPresent()) { 
			return user.get();
		} else {
			throw new UserException("유저 정보가 없습니다.");
		}
	}
	
}
