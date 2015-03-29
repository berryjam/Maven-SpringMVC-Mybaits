package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Visit;

public interface VisitRepository {

	void save(Visit visit) throws DataAccessException;

	List<Visit> findByPetId(Integer petId);
}
