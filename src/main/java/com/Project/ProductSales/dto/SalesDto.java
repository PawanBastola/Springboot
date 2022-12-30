package com.Project.ProductSales.dto;

import java.sql.Date;
import java.time.LocalDate;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesDto {
	private Integer id;
	private String customer_name;
	private String product_name;
	private Integer product_id; // foreign key
	private Integer customer_id; // foreign key
	private LocalDate date_of_sale;
	private Integer quantity;
	private Double price;
}
