package com.Project.ProductSales.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.ProductSales.dto.CustomerDto;
import com.Project.ProductSales.repo.CustomerRepository;
import com.Project.ProductSales.service.CustomerService;
import com.Project.ProductSales.Model.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
//		Customer customer = new Customer(customerDto.getId(), customerDto.getFull_name(),
//				customerDto.getEmail_address(), customerDto.getMobile_number(), customerDto.getIs_regular(),
//				customerDto.getDate_of_birth(), customerDto.getAddresses());

		Customer customer = Customer.builder()
				.id(customerDto.getId())
				.full_name(customerDto.getFull_name())
				.email_address(customerDto.getEmail_address())
				.mobile_number(customerDto.getMobile_number())
				.is_regular(customerDto.getIs_regular())
				.date_of_birth(customerDto.getDate_of_birth())
				.addresses(customerDto.getAddresses()).build();

		customerRepository.save(customer);

		return CustomerDto.builder().id(customer.getId()).full_name(customer.getFull_name())
				.email_address(customer.getEmail_address()).mobile_number(customer.getMobile_number())
				.date_of_birth(customer.getDate_of_birth()).is_regular(customer.getIs_regular())
				.addresses(customer.getAddresses()).build();
	}

	@Override
	public CustomerDto find_by_id(Integer id) {
		// TODO Auto-generated method stub
		Customer customer;
		Optional<Customer> optionalCustomer = customerRepository.findById(id);

		if (optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
			return CustomerDto.builder().id(customer.getId()).full_name(customer.getFull_name())
					.email_address(customer.getEmail_address()).is_regular(customer.getIs_regular())
					.date_of_birth(customer.getDate_of_birth()).addresses(customer.getAddresses())
					.mobile_number(customer.getMobile_number()).build();
		}

		return null;
	}

	@Override
	public List<CustomerDto> findAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> data = customerRepository.findAll();

		return data.stream()
				.map(obj -> CustomerDto.builder().id(obj.getId()).full_name(obj.getFull_name())
						.email_address(obj.getEmail_address()).is_regular(obj.getIs_regular())
						.mobile_number(obj.getMobile_number()).addresses(obj.getAddresses())
						.date_of_birth(obj.getDate_of_birth()).build())
				.collect(Collectors.toList());

	}

	@Override
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);

	}

	// auto generating the implementations

}
