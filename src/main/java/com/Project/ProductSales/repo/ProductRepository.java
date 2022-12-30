package com.Project.ProductSales.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.ProductSales.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}



