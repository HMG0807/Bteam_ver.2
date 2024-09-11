package com.example.demo.ServiceCenter;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

	@NotEmpty(message = "내용이 존재하지 않습니다")
	private String contents;
}
