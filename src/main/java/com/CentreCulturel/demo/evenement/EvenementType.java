package com.CentreCulturel.demo.evenement;

import java.util.List;

import com.CentreCulturel.demo.base.BaseClass;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class EvenementType extends BaseClass{
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumEvent name;
	@JsonBackReference
	@OneToMany(mappedBy = "typeEvent")
	private List<Evenement> evenements;
	

}
