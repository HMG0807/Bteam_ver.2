package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class buyuser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer buyuserId;	
	
	@Column(nullable = false, unique = true)
	private String id;
	
	@Column(nullable = false)
	private String pw;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String tell;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private LocalDateTime registerDate;
	
	@Column(nullable = false)
	private String role;
	
	@OneToMany(mappedBy = "buyuser", cascade = CascadeType.REMOVE)
	private List<cart> cartList;
	
	@OneToMany(mappedBy = "buyuser", cascade = CascadeType.REMOVE)
	private List<servicecenterquestion> servicecenterquestionList;
	
	@OneToMany(mappedBy = "buyuser", cascade = CascadeType.REMOVE)
	private List<productquestion> productquestionList;
	
	@OneToMany(mappedBy = "buyuser", cascade = CascadeType.REMOVE)
	private List<prductorder> prductorderList;
	
}

