package com.Project.ProductSales.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.Project.ProductSales.dto.ProductDto;
import com.Project.ProductSales.service.ProductService;

@Controller
@RequestMapping("Product")
public class ProductController {

	// creating variable of ProductService to use for crud operations.
	@Autowired
	private ProductService productService;

	@GetMapping("home")
	public String productHome() {
		return "Product/home";

	}

	@GetMapping("register")
	public String productRegister(Model model) {
		if (model.getAttribute("productDto") == null)
			model.addAttribute("productDto", new ProductDto());

		model.addAttribute("productDtoList", productService.findAllProduct());
		return "Product/register";
	}

	@PostMapping("insert")
	public String productRegister(@ModelAttribute ProductDto productDto, RedirectAttributes redirectAtrributes) {

		productDto.setProduct_stock(true);
		productDto = productService.saveProductDto(productDto);
		String message = "";
		if (productDto == null) {
			message = "Data not Inserted";
		} else {
			message = "Data inserted successfully";
		}
		redirectAtrributes.addFlashAttribute("message", message);
		return "redirect:/Product/register";
	}

	@GetMapping("edit/{id}")
	public String findProductById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {

		ProductDto productDto = productService.find_By_Id(id);
		if (productDto != null) {
			redirectAttributes.addFlashAttribute("productDto", productDto);
		}

		return "redirect:/Product/register";
	}
	
	@GetMapping("delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		
		productService.deleteProductById(id);
		return "redirect:/Product/register";
	}

}
