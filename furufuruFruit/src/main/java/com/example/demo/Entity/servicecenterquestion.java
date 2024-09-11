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
public class servicecenterquestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cquestionId;

	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String contents;
	
	@Column(nullable = false)
	private LocalDateTime questionDate;
	
	@ManyToOne
	@JoinColumn(name="buyuserId")
	private buyuser buyuser;
	
	@OneToOne(mappedBy = "servicecenterquestion", cascade = CascadeType.REMOVE)
	private servicecenteranswer servicecenteranswer;
	
}






