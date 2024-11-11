package com.CentreCulturel.demo.message;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.springframework.data.annotation.CreatedDate;

import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.evenementscientifique.Scientifique;
import com.CentreCulturel.demo.formateur.Formateur;
import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Message extends BaseClass {
	
	private String titre;
	@Column(nullable = false)
	private String description;
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private LocalDate dateCreation;
	@JsonManagedReference
	 @ManyToOne()
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	

}
