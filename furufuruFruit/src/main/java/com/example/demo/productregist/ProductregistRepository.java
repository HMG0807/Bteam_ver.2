package com.example.demo.productregist;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.product;

public interface ProductregistRepository extends JpaRepository<product, Integer> {

}
