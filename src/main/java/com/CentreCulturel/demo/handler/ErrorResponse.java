package com.CentreCulturel.demo.handler;

import java.util.Set;

import com.CentreCulturel.demo.Exception.UtilisateurAssignementException;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class ErrorResponse {
	private Set<String> validationErrors;
	private String errorMessage;
	private int errorcode;

}
