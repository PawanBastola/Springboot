package com.Project.ProductSales.controller.sales;

import java.sql.Date;
import java.time.LocalDate;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Project.ProductSales.dto.SalesDto;
import com.Project.ProductSales.service.CustomerService;
import com.Project.ProductSales.service.ProductService;
import com.Project.ProductSales.service.SalesService;

@Controller
@RequestMapping("Sales")
public class SalesController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SalesService salesService;

	@GetMapping("home")
	public String salesHome(Model model) {

		if (model.getAttribute("salesDto") == null) {
			model.addAttribute("salesDto", new SalesDto());
		}

		// populating the drop down list for Customer
		model.addAttribute("customerDtoList", customerService.findAllCustomer());
		// populating the drop down list for Product
		model.addAttribute("productDtoList", productService.findAllProduct());
		model.addAttribute("salesDtoList", salesService.findAllsales());
		return "Sales/home";
	}

	@PostMapping("insert")
	public String insert(@ModelAttribute SalesDto salesDto) {

		LocalDate date = LocalDate.now();
		salesDto.setDate_of_sale(date);
		salesService.saveCustomer(salesDto);

		return "redirect:/Sales/home";
	}

	@GetMapping("edit/{id}")
	public String editSales(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

		SalesDto salesDto = salesService.find_by_id(id);
		redirectAttributes.addFlashAttribute("salesDto", salesDto);
		return "redirect:/Sales/home";
	}

	@GetMapping("delete/{id}")
	public String deleteSales(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

		salesService.deleteSales(id);

		return "redirect:/Sales/home";
	}
}
