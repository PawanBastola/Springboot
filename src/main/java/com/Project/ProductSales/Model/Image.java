package com.Project.ProductSales.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="tbl_image")
public class Image {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String file_path_name;
}
