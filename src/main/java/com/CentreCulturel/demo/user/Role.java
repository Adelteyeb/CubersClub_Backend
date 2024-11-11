package com.CentreCulturel.demo.user;

import java.util.List;

import com.CentreCulturel.demo.base.BaseClass;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Id;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends BaseClass {
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
    private EnumRole name;
	@ManyToMany(mappedBy = "roles")
	@JsonManagedReference
	private List<User> users;
	

}
