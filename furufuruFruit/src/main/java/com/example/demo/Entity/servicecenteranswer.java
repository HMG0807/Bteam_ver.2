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
public class servicecenteranswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer canswerId;

	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String contents;
	
	@Column(nullable = false)
	private LocalDateTime answerDate;
	
	@OneToOne
	@JoinColumn(name="cquestionId")
	private servicecenterquestion servicecenterquestion;
	
}
