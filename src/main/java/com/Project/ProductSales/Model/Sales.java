package com.Project.ProductSales.Model;
import java.sql.Date;

import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

	private Integer id;
	private Integer product_id; //foreign key
	private Integer customer_id; //foreign key
	private Date date_of_sale;
	private Integer quantity;
	private Double price;
}
