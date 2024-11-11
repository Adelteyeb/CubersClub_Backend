package com.CentreCulturel.demo.membre;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.CentreCulturel.demo.administrateur.Administrateur;
import com.CentreCulturel.demo.culturel.Culturel;
import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.idee.Idee;
import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("USER")
public class Membre extends User {
	
	@JsonBackReference
	@OneToMany(mappedBy = "utilisateur")
	private List<Idee> ides;
	@JsonBackReference
	@ManyToMany(fetch=FetchType.LAZY)	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinTable(name="event_user",
			joinColumns=@JoinColumn(name="EVENT_ID",referencedColumnName = "Id"),
			inverseJoinColumns = @JoinColumn(name="UTIL_ID",referencedColumnName = "Id"))
	private List<Evenement> evenements;
	
	@ManyToOne( )
	@JoinColumn(name = "Dept_utili_id")
	@JsonBackReference
	private Departement departement;
	

}
