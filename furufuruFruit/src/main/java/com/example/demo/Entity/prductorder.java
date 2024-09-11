package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class prductorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(nullable = false)
	private Integer count;
	
	@Column(nullable = false)
	private LocalDateTime orderDate;
	
	@Column(nullable = false)
	private String paymentYn;
	
	@ManyToOne
	@JoinColumn(name = "buyuserId")
	private buyuser buyuser;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private product product;
	
	@OneToOne(mappedBy = "prductorder", cascade = CascadeType.REMOVE)
	private delivery delivery;
	
}
