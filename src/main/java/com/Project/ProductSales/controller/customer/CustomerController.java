package com.Project.ProductSales.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Project.ProductSales.Model.Customer;
import com.Project.ProductSales.dto.CustomerDto;
import com.Project.ProductSales.service.CustomerService;

@Controller
@RequestMapping("Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("home")
	public String customerHome() {
		return "Customer/home";
	}

	// Customer/add
	@GetMapping("register")
	public String registerPage(Model model) {
		if(model.getAttribute("customerDto")==null)
		model.addAttribute("customerDto", new CustomerDto());
		model.addAttribute("customerDtoList", customerService.findAllCustomer());
		return "Customer/register";
	}

	// overriding the method for insertion
	@PostMapping("insert")
	public String registerPage(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttrinbutes) {
		customerDto = customerService.saveCustomer(customerDto);
		String message = "";
		if (customerDto == null) {
			message = "Data not inserted";
		} else {
			message = "data inserted successfully";
		}
		// call a service to save the data.
		redirectAttrinbutes.addFlashAttribute("message", message);
		return "redirect:/Customer/register";

	}

	//edit code
	@GetMapping("edit/{id}")
	public String editCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		CustomerDto customerDto = customerService.find_by_id(id);
		redirectAttributes.addFlashAttribute("customerDto", customerDto);
		return "redirect:/Customer/register";
	}
	
	// delete code
	@GetMapping("delete/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
		
		return "redirect:/Customer/register";
	}
	

}
