package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vet;

public interface VetRepository {
	Collection<Vet> findAll() throws DataAccessException;
}
