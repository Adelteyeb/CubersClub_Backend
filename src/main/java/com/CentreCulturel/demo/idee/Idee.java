package com.CentreCulturel.demo.idee;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.CentreCulturel.demo.base.BaseClass;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.user.Role;

import com.CentreCulturel.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Idee extends BaseClass {
	@Column(nullable =false)
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date dateCreation;
	@ManyToOne()
	@JoinColumn(name="UTILI_ID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"applications","hibernateLazyInitializer"})
	private Membre utilisateur;
	

}
