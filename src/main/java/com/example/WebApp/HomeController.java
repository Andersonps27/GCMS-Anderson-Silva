package com.example.WebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/Anderson")
	public @ResponseBody String greetingAnderson() {
		return "Hello, Anderson!";
	}	
}
