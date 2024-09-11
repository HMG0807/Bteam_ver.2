package com.example.demo.User.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.buyuser;

public interface UserRepository extends JpaRepository<buyuser, Long>{
	Optional<buyuser> findById(String username);

}

