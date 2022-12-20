package com.Project.ProductSales.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Project.ProductSales.Model.Product;

@Controller
@RequestMapping("Product")
public class ProductController {

	@GetMapping("home")
	public String productHome() {
		return "Product/home";

	}

	@GetMapping("register")
	public String productRegister() {
		return "Product/register";
	}

	@PostMapping("insert")
	public String productRegister(Product product) {
		//id and product_stock null auxa

		return "Product/register";
	}

}
