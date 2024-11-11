package com.CentreCulturel.demo.formateur;

import java.util.List;

import com.CentreCulturel.demo.culturel.Culturel;
import com.CentreCulturel.demo.evenementscientifique.Scientifique;
import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("FORM")
public class Formateur  extends User {
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="event_scientifique_formateur",
			joinColumns=@JoinColumn(name="SCIEN_ID",referencedColumnName = "Id"),
			inverseJoinColumns = @JoinColumn(name="FORM_ID",referencedColumnName = "Id"))
	private List<Scientifique> scientifiques;

}
