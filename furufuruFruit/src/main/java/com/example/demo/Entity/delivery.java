package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryId;
	
	@Column(nullable = false)
	private String deliveryStatus;
	
	@Column(nullable = false)
	private LocalDateTime deliveryDate;
	
	@OneToOne
	@JoinColumn(name="orderId")
	private prductorder prductorder;
	
}
