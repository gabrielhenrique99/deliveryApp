package br.com.ifce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
	@GetMapping
	public String index(Model model) {
		return "index.html";
	}
	
	@PostMapping("/login")
	public String login () {
		return "redirect:/login";
	}

}
