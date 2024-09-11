package com.example.demo.ServiceCenter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.servicecenterquestion;

public interface QuestionResponsitory extends JpaRepository<servicecenterquestion, Integer>{
	Page<servicecenterquestion> findAll(Pageable pageable);
}