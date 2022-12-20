package com.Project.ProductSales.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Project.ProductSales.Model.Customer;

@Controller
@RequestMapping("Customer")
public class CustomerController {

	
	@GetMapping("home")
	public String customerHome() {
		return "Customer/home";
	}
	
	
	//Customer/add
	@GetMapping("register")
	public String registerPage() {
		return "Customer/register";
	}
	
	//overriding the method for insertion
	@PostMapping("insert")
	public String registerPage(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
		//id null auxa
		//sending data to the thymeleaf view. //in register.html --->>> <p th:text="${d1}"> </p>
		//redirectattributes vaneko update ma kaam lagna sakne kura ho.
		redirectAttributes.addFlashAttribute("d1", customer.getFull_name());
		redirectAttributes.addFlashAttribute("d2", customer.getMobile_number());
		return "redirect:/Customer/home";
		
	}
	
	//update code
	@PostMapping("update")
	public String updateCustomer() {
		return "/Customer/update";
	}
}
