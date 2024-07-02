package com.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.NormalUserDto;
import com.health.dto.SignupDto;
import com.health.dto.VerifyEmailDto;
import com.health.entity.NormalUser;
import com.health.entity.UserQuery;
import com.health.helper.UserNotFoundException;
import com.health.service.EmailSenderService;
import com.health.service.NormalUserService;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class NormalUserController {
	
	@Autowired
	private NormalUserService userService;
	
	@Autowired
	private EmailSenderService emailService;

	@PostMapping("/")
	public ResponseEntity<?> saveUser(@RequestBody SignupDto user) {
		try {
			System.out.println("SignupDto = " + user.toString()+ " "+user.getEmail());
			NormalUser newUser = userService.saveNormalUser(user.toEntity());
			System.out.println("Saved user "+newUser.toString());
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOTP(@RequestBody VerifyEmailDto mailDto) {
	    emailService.sendEmail(mailDto.getEmail(), "Verify Your Email", "Otp for Email Verification is " + mailDto.getOtp());
	       return ResponseEntity.ok("OTP Sent successfully.");
	}
	
	@GetMapping("/getUser/{email}")
	public ResponseEntity<?> getUser(@PathVariable String email) {
		try {
			NormalUser user = userService.getUser(email);
			if (user != null) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/updateUser/{email}")
	public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody NormalUserDto user) {
		try {
			NormalUser updatedUser = userService.updateUser(email, user);
			return ResponseEntity.ok(updatedUser);
		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/query")
	public ResponseEntity<?> postQuery(@RequestBody UserQuery userQuery) {
		try {
			String emailBody = "Your Query Has Been Successfully Saved! " + "\n\n" +
					"We appreciate your interest in our services and will be in touch with you shortly. " + "\n\n" +
					"Thank you for choosing our advanced Health Care System..\n\n" +
					"Best regards,\n" +
					"Health Care System";

			emailService.sendEmail(userQuery.getEmail(), "Health Care System", emailBody);
			
			UserQuery newQuery = userService.addQuery(userQuery);
			return new ResponseEntity<>(newQuery, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
