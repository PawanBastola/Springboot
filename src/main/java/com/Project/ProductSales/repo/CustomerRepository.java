package com.Project.ProductSales.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Project.ProductSales.Model.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
