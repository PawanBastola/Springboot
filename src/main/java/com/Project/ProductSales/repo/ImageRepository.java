package com.Project.ProductSales.repo;
import org.springframework.data.jpa.repository.JpaRepository;


import com.Project.ProductSales.Model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
