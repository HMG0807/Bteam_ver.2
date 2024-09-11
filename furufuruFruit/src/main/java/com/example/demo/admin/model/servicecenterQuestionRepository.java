package com.example.demo.admin.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.servicecenterquestion;

public interface servicecenterQuestionRepository extends JpaRepository<servicecenterquestion, Integer> {

	Page<servicecenterquestion> findAll(Pageable pageable);
}
