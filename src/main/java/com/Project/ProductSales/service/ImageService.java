package com.Project.ProductSales.service;

import java.io.IOException;
import java.util.List;

import com.Project.ProductSales.dto.ImageDto;

public interface ImageService {

	ImageDto saveImage(ImageDto imageDto) throws IOException;
	ImageDto findImageById(Integer id);
	String deleteImage(Integer id);
	List<ImageDto> getAllImages(); 
}
