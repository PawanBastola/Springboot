package com.Project.ProductSales.Model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_sales")
public class Sales {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="customer_id")
	private Integer customer_id; //foreign key
	@Column(name="product_id")
	private Integer product_id; //foreign key
	@Column(name="date_of_sale")
	private LocalDate date_of_sale;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="price")
	private Double price;
}
