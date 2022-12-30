package com.Project.ProductSales.service.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.ProductSales.Model.Product;
import com.Project.ProductSales.dto.ProductDto;
import com.Project.ProductSales.repo.ProductRepository;
import com.Project.ProductSales.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import java.util.stream.Stream;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto saveProductDto(ProductDto productDto) {
		// TODO Auto-generated method stub
		 
				
		Product product = Product.builder()
				.id(productDto.getId())
				.product_name(productDto.getProduct_name())
				.product_price(productDto.getProduct_price())
				.product_company_name(productDto.getProduct_company_name())
				.product_stock(productDto.getProduct_stock())
				.build();
		
		productRepository.save(product); //insert, update
		
		//using stream api to map the productDto to product
		return ProductDto.builder().id(product.getId()).product_company_name(product.getProduct_company_name())
				.product_name(product.getProduct_name()).product_price(product.getProduct_price())
				.product_stock(product.getProduct_stock()).build();
	}

	@Override
	public List<ProductDto> findAllProduct() {
		// TODO Auto-generated method stub
		List<Product> productList = productRepository.findAll();

		return productList.stream()
				.map(product -> ProductDto.builder().id(product.getId()).product_name(product.getProduct_name())
						.product_company_name(product.getProduct_company_name())
						.product_price(product.getProduct_price()).product_stock(product.getProduct_stock()).build())
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto find_By_Id(Integer id) {
		// TODO Auto-generated method stub
		Product product;
		Optional<Product> optionalProduct = productRepository.findById(id);

		if (optionalProduct.isPresent()) {
			product = optionalProduct.get();
			return ProductDto.builder().id(product.getId()).product_name(product.getProduct_name())
					.product_company_name(product.getProduct_company_name()).product_price(product.getProduct_price())
					.product_stock(product.getProduct_stock()).build();
		}

		return null;
	}

	@Override
	public void deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);

	}

}
