package com.Project.ProductSales.service;

import java.util.List;


import com.Project.ProductSales.dto.SalesDto;

public interface SalesService {

	//save 
		SalesDto saveCustomer(SalesDto salesdto);
		//find
		SalesDto find_by_id(Integer id);
		
		//findbyid
		List<SalesDto> findAllsales();
		
		//delete
		void deleteSales(Integer id);
}
