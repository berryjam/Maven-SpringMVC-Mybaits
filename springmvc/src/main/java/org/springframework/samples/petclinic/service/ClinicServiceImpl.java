package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClinicServiceImpl implements ClinicService {
	private PetRepository petRepository;
	private VetRepository vetRepository;
	private OwnerRepository ownerRepository;
	private VisitRepository visitRepository;

	@Autowired
	public ClinicServiceImpl(PetRepository petRepository,
			VetRepository vetRepository, OwnerRepository ownerRepository,
			VisitRepository visitRepository) {
		this.petRepository = petRepository;
		this.vetRepository = vetRepository;
		this.ownerRepository = ownerRepository;
		this.visitRepository = visitRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<PetType> findPetTypes() throws DataAccessException {
		return petRepository.findPetTypes();
	}

	@Override
	@Transactional(readOnly = true)
	public Owner findOwnerById(int id) throws DataAccessException {
		return ownerRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Pet findPetById(int id) throws DataAccessException {
		return petRepository.findById(id);
	}

	@Override
	@Transactional
	public void savePet(Pet pet) throws DataAccessException {
		petRepository.save(pet);
	}

	@Override
	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "vets")
	public Collection<Vet> findVets() throws DataAccessException {
		return vetRepository.findAll();
	}

	@Override
	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Owner> findOwnerByLastName(String lastName)
			throws DataAccessException {
		return ownerRepository.findByLastName(lastName);
	}

}
