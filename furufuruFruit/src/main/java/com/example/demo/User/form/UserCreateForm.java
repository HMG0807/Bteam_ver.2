package com.example.demo.User.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	
	@Size(min =6, max = 25)
	@NotEmpty(message = "사용자 ID 는 필수항목 입니다.")
	private String id;
	
	@NotEmpty(message = "비밀번호는 필수항목 입니다.")
	private String pw;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목 입니다.")
	private String pw2;
	
	@NotEmpty(message = "이메일은 필수항목 입니다.")
	private String email1;
	
	@NotEmpty(message = "이메일은 필수항목 입니다.")
	private String email2;
	
	@NotEmpty(message = "이름은 필수항목 입니다.")
	private String name;
	
	@NotEmpty(message = "전화번호는 필수항목입니다")
	private String tell;
	
	@NotEmpty(message = "주소는 필수항목입니다")
	private String address1;
	
	@NotEmpty(message = "주소는 필수항목입니다")
	private String address2;
	
	@NotEmpty(message = "주소는 필수항목입니다")
	private String address3;
	
	@NotEmpty(message = "성별은 필수항목입니다")
	private String gender;
	
	@NotEmpty(message = "유저정보는 필수항목입니다")
	private String role;

	
}