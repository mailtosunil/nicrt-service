package com.nicrt.app.controller;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/udem")
public class LoginController {
	
	@GetMapping("/login/{username}/{password}")
	public boolean validateUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		
		System.out.println("UserName: "+username);
		System.out.println("Password: "+password);
		return true;
	}
}
