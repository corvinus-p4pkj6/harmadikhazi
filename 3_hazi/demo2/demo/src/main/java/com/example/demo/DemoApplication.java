package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("")
@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/harmadik")
	@ResponseBody
	public String welcomeUserByName(@RequestParam Optional<String> name) {
		if (name.isPresent()) {
			return "Hello " + name.get() + "!";
		}
		else {
			return "Hello felhasználó!";
		}
	}

	@PostMapping("/harmadik")
	@ResponseBody
	public String reverseText(@RequestParam Optional<String> text)
	{
		StringBuilder stringBuilder = new StringBuilder();

		if (text.isPresent()) {
			stringBuilder.append(text.get());
			stringBuilder.reverse();
		}
		else {
			String defaultText = "Alma a fa alatt";
			stringBuilder.append(defaultText);
			stringBuilder.reverse();
		}

		String result = stringBuilder.toString();
		return result;
	}

}