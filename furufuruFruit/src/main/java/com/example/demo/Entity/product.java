package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String category;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer amount;
	
	@Column(nullable = false)
	private String path;
	
	@Column(nullable = false)
	private String explan;
	
	@ManyToOne
	@JoinColumn(name = "buyuserId")
	private buyuser buyuser;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<cart> cartList;
	
}
