package com.CentreCulturel.demo.idee;

import java.sql.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.membre.Membre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Service
public class IdeeMapper {
	public Idee toidee(IdeeRequest ideereq) {
		return Idee.builder()
				.id(ideereq.getId())
				.name(ideereq.getName())
				.description(ideereq.getDescription())
				//.dateCreation(ideereq.getDateCreation())
				//.utilisateur(ideereq.getUitilisateur())
				.build();
	}
	public IdeeResponse toideeDTO(Idee idee) {
		return IdeeResponse.builder()
				.id(idee.getId())
				.name(idee.getName())
				.description(idee.getDescription())
				//.dateCreation(idee.getDateCreation())
				//.utilisateur(idee.getUtilisateur())
				.build();
	}
	
}
