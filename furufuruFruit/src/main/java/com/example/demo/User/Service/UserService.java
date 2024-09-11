package com.example.demo.User.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.buyuser;
import com.example.demo.User.Exception.UserException;
import com.example.demo.User.Repository.UserRepository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	public buyuser create(String id,String pw,String email1,String email2, String name, String tell, String address1,String address2,String address3,String gender, String role) {
		
		buyuser user = new buyuser();
		user.setId(id);
		user.setPw(passwordEncoder.encode(pw));
		user.setEmail(email1+"@"+email2);
		user.setName(name);
		user.setTell(tell);
		user.setAddress(address1+" "+address2+" "+address3);
		user.setGender(gender);
		user.setRegisterDate(LocalDateTime.now());
		user.setRole(role);
		
		
		this.userRepository.save(user);
		return user;
		
	}
	
	public buyuser getUser(String id) throws UserException {
		Optional<buyuser> buyuser = this.userRepository.findById(id);
		if(buyuser.isPresent()) {
			return buyuser.get();
		}
		else {
			throw new UserException("해당 유저가 존재하지 않습니다");
		}
	}
}