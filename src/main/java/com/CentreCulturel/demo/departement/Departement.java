package com.CentreCulturel.demo.departement;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.jsf.FacesContextUtils;

import com.CentreCulturel.demo.administrateur.Administrateur;
import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@SuperBuilder
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Departement extends BaseClass{

@Column(nullable = false,unique = true)
private String name;
private String description;
@JsonManagedReference
@OneToOne()
@JoinColumn(name = "ADMIN_ID")
@JsonIgnoreProperties({"applications","hibernateLazyInitializer"})
private Administrateur administrateur;

@OneToMany(mappedBy = "departement",cascade = {CascadeType.REMOVE})
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonManagedReference
private List<Membre> listUtilisateur;
@OneToMany(mappedBy = "departements")
@OnDelete(action = OnDeleteAction.CASCADE)
private List<Evenement> evenements;
}
