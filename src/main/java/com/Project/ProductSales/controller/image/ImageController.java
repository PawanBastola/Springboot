package com.Project.ProductSales.controller.image;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Project.ProductSales.dto.ImageDto;
import com.Project.ProductSales.service.ImageService;

@Controller
@RequestMapping("Image")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@GetMapping("home")
	public String homePage(Model model) {
		
		if(model.getAttribute("imageDto")==null) {		
			model.addAttribute("imageDto",new ImageDto());
		}
		
		model.addAttribute("imageDtoList", imageService.getAllImages());
		
		return "Image/home";
	}
	
	@PostMapping("insert")
	public String insertImage(@ModelAttribute ImageDto imageDto, RedirectAttributes redirectAttributes) throws IOException {
		
		
			if(imageDto != null) {
				imageDto = imageService.saveImage(imageDto);
				//redirectAttributes.addFlashAttribute("imageDto", imageDto);
			}
			
	
		
		return "redirect:/Image/home";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		
		
		//variable message stores the success and failure message
		String message = imageService.deleteImage(id);
		
		return "redirect:/Image/home";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		ImageDto imageDto = imageService.findImageById(id);
		redirectAttributes.addFlashAttribute("imageDto", imageDto);
		return "redirect:/Image/home";
	}
	
	
}






























