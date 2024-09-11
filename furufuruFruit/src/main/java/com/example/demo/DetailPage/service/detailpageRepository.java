package com.example.demo.DetailPage.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.product;

public interface detailpageRepository extends JpaRepository<product, Integer> {

}
