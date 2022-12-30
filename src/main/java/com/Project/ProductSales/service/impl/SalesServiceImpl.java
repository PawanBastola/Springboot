package com.Project.ProductSales.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.ProductSales.Model.Sales;
import com.Project.ProductSales.dto.SalesDto;
import com.Project.ProductSales.repo.SalesRepository;
import com.Project.ProductSales.service.SalesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	private SalesRepository salesRepository;
	
	@Override
	public SalesDto saveCustomer(SalesDto salesdto) {
		// TODO Auto-generated method stub
		Sales sales = Sales.builder()
				.id(salesdto.getId())
				.customer_id(salesdto.getCustomer_id())
				.product_id(salesdto.getProduct_id())
				.date_of_sale(salesdto.getDate_of_sale())
				.quantity(salesdto.getQuantity())
				.price(salesdto.getPrice())
				.build();
		salesRepository.save(sales);
		
		return SalesDto.builder()
				.id(sales.getId())
				.customer_id(sales.getCustomer_id())
				.product_id(sales.getProduct_id())
				.date_of_sale(sales.getDate_of_sale())
				.quantity(sales.getQuantity())
				.price(sales.getPrice())
				.build();
	}

	@Override
	public SalesDto find_by_id(Integer id) {
		// TODO Auto-generated method stub
		Sales sales;
		Optional<Sales> optionalSales = salesRepository.findById(id);
		if(optionalSales.isPresent()) {
			sales= optionalSales.get();
			return SalesDto.builder()
					.id(sales.getId())
					.customer_id(sales.getCustomer_id())
					.product_id(sales.getProduct_id())
					.date_of_sale(sales.getDate_of_sale())
					.quantity(sales.getQuantity())
					.price(sales.getPrice())
					.build();
		}
		
		return null;
	}

	@Override
	public List<SalesDto> findAllsales() {
		// TODO Auto-generated method stub
		
		List<Sales> salesList = salesRepository.findAll();
		
		return salesList.stream().map(s->SalesDto.builder()
				.id(s.getId())
				.customer_id(s.getCustomer_id())
				.product_id(s.getProduct_id())
				.date_of_sale(s.getDate_of_sale())
				.quantity(s.getQuantity())
				.price(s.getPrice())
				.build()).sorted((sales1, sales2) -> sales1.getDate_of_sale().compareTo(sales2.getDate_of_sale()))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteSales(Integer id) {
		
		salesRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	
	
}
