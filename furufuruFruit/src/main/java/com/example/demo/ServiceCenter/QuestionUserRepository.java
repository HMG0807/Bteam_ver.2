package com.example.demo.ServiceCenter;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.buyuser;

public interface QuestionUserRepository extends JpaRepository<buyuser, Integer> {

	Optional<buyuser> findById(String id);
}
