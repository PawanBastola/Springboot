package com.Project.ProductSales.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.*;

//lombok annotation
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	private Integer id;
	private String full_name;
	private String email_address;
	private String mobile_number;
	private Boolean is_regular;// not required
	private LocalDate date_of_birth;
	private List<String> addresses;

}
