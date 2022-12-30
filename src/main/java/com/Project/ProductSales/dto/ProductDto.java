package com.Project.ProductSales.dto;
import lombok.*;

//lombok annotations
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private Integer id;
	private String product_name;
	private Double product_price;
	private String product_company_name; // not required
	private Boolean product_stock; // not required

}
