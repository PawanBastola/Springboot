package com.Project.ProductSales.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.ProductSales.Model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

}
