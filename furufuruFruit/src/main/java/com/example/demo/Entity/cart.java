package com.example.demo.Entity;
// 이순
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column(nullable = false)
	private Integer count;
	
	@Column(nullable = false)
	private LocalDateTime cartDate;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private product product;
	
	@ManyToOne
	@JoinColumn(name = "buyuserId")
	private buyuser buyuser;
	
}
