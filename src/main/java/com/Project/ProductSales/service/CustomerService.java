package com.Project.ProductSales.service;

import java.util.List;

import com.Project.ProductSales.dto.CustomerDto;

public interface CustomerService {

	//save 
	CustomerDto saveCustomer(CustomerDto customerdto);
	//find
	CustomerDto find_by_id(Integer id);
	
	//findbyid
	List<CustomerDto> findAllCustomer();
	
	//delete
	void deleteCustomer(Integer id);
	
	
}
