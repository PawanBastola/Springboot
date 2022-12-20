package com.Project.ProductSales.Model;
import java.sql.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

	private Integer id;
	private String full_name;
	private String email_address;
	private String mobile_number;
	private Boolean is_regular;// not required
	private Date date_of_birth;
	private List<String> addresses;
}
