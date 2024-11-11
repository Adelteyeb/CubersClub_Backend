package com.CentreCulturel.demo.evenement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.idee.Idee;
import com.CentreCulturel.demo.membre.Membre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Typ_Event",discriminatorType = DiscriminatorType.STRING)
public class Evenement extends BaseClass {
	@Column(nullable =false)
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private LocalDate dateCreation;
	@Column(nullable = false)
	private String theme;
	@ManyToOne()
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="DEPT_ID")
	private Departement departements;
	@JsonManagedReference
	@ManyToMany(mappedBy = "evenements",fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Membre> listUtilisateur;
	private String typeEvent;

}
