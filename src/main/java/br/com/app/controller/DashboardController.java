package br.com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardController extends BaseController {

	@GetMapping({"", "/", "/index"})
	public String index() {
		return "/home/dashboard";
	}

	
	
	
}
