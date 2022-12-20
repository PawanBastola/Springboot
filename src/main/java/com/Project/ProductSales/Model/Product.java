package com.Project.ProductSales.Model;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer id;
	private String product_name;
	private Double product_price;
	private String product_company_name; //not required
	private Boolean product_stock; //not required
	
}
