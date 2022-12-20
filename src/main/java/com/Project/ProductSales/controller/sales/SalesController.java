package com.Project.ProductSales.controller.sales;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Sales")
public class SalesController {

	@GetMapping("home")
	public String salesHome() {
		return "Sales/home";
	}
}
