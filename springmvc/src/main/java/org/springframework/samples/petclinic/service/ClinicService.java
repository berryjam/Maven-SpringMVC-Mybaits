package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;

public interface ClinicService {

	public Collection<PetType> findPetTypes() throws DataAccessException;

	public Owner findOwnerById(int id) throws DataAccessException;

	public Pet findPetById(int id) throws DataAccessException;

	public void savePet(Pet pet) throws DataAccessException;

	public void saveVisit(Visit visit) throws DataAccessException;

	public Collection<Vet> findVets() throws DataAccessException;

	public void saveOwner(Owner owner) throws DataAccessException;

	Collection<Owner> findOwnerByLastName(String lastName)
			throws DataAccessException;

}