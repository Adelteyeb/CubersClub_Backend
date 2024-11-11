package com.CentreCulturel.demo.idee;

import java.sql.Date;
import java.util.List;

import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.superAdmin.SupperAdminRequest;
import com.CentreCulturel.demo.user.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Getter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdeeRequest {
	private Integer id;
	@NotNull(message = "First name must be not null")
	private String name;
	@NotNull(message = "Description must be not null")
	private String description;
	//@NotNull(message = "Date must be not null")
	//private Date dateCreation;
	//private Utilisateur uitilisateur;
}
