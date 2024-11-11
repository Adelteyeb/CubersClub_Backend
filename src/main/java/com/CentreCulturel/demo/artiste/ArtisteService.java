package com.CentreCulturel.demo.artiste;
import java.util.List;
public interface ArtisteService {
	Integer save(ArtisteRequest artreq);
	ArtisteResponse findByID(Integer id);
	List<ArtisteResponse> findAll();
	void delete(Integer id);
	ArtisteResponse findByEmail(String email);
	List<ArtisteResponse> findByFirstNameAndLastName(String firstName, String LastName);
}
