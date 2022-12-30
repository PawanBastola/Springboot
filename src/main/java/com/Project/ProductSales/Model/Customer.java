package com.Project.ProductSales.Model;

import java.time.LocalDate;
import java.util.List;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_customer",schema="devschema")
public class Customer {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="full_name", length = 100)
	private String full_name;
	@Column(name="email_address", length = 100)
	private String email_address;
	@Column(name="mobile_number", length = 100)
	private String mobile_number;
	@Column(name="is_regular")
	private Boolean is_regular;// not required
	@Column(name="date_of_birth")
	private LocalDate date_of_birth;
	@Column(name="addresses")
	private List<String> addresses;
}
