package com.Project.ProductSales.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Project.ProductSales.dto.ProductDto;


@Service
public interface ProductService {

	//insert, update
	ProductDto saveProductDto(ProductDto productDto);
	//find_all used for listing the data;
	List<ProductDto> findAllProduct();
	//find a single entity by id;
	ProductDto find_By_Id(Integer id);
	//delete
	void deleteProductById(Integer id);

	
	
	
	
}
