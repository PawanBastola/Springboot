package com.Project.ProductSales.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "product_name", length = 100)
	private String product_name;
	@Column(name = "product_price")
	private Double product_price;
	@Column(name="product_company_name")
	private String product_company_name; // not required
	@Column(name="product_stock")
	private Boolean product_stock; // not required

}
