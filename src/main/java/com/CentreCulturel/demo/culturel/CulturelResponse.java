package com.CentreCulturel.demo.culturel;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CulturelResponse {
	private Integer id;
	@NotNull(message = "Name must be not null")
	private String name;
	@NotNull(message = "Description must be not null")
	private String description;
	@NotNull(message = "Date must be not null")
	private LocalDate dateCreation;
	@NotNull(message = "Theme must be not null")
	private String theme;
	@NotNull(message = "Type must be not null")
	private String typeEvent;
	
}
