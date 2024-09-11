package com.example.demo.Entity;

import java.time.LocalDateTime;

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
public class productanswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer panswerId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String contents;
	
	@Column(nullable = false)
	private LocalDateTime answerDate;
	
	@OneToOne
	@JoinColumn(name="pquestionId")
	private productquestion productquestion;
	
	@ManyToOne
	@JoinColumn(name = "buyuserId")
	private buyuser buyuser;
	
}
