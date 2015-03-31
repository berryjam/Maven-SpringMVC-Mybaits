package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("pet")
public class PetController {

	private final ClinicService clinicService;

	@Autowired
	public PetController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	@ModelAttribute("types")
	public Collection<PetType> populatedPetTypes() {
		return this.clinicService.findPetTypes();
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/owners/{ownerId}/pets/new", method = RequestMethod.GET)
	public String initCreationForm(@PathVariable("ownerId") int ownerId,
			Map<String, Object> model) {
		Owner owner = this.clinicService.findOwnerById(ownerId);
		Pet pet = new Pet();
		owner.addPet(pet);
		model.put("pet", pet);
		return "pets/createOrUpdatePetForm";
	}

	@RequestMapping(value = "/owners/{ownerId}/pets/new", method = RequestMethod.POST)
	public String processCreationForm(@ModelAttribute("pet") Pet pet,
			BindingResult result, SessionStatus status) {
		new PetValidator().validate(pet, result);
		if (result.hasErrors()) {
			return "pets/createOrUpdatePetForm";
		} else {
			this.clinicService.savePet(pet);
			status.setComplete();
			return "redirect:/owners/{ownerId}";
		}
	}

	@RequestMapping(value = "/owners/*/pets/{petId}/edit", method = RequestMethod.GET)
	public String initUpdateForm(@PathVariable("petId") int petId,
			Map<String, Object> model) {
		Pet pet = this.clinicService.findPetById(petId);
		model.put("pet", pet);
		return "pets/createOrUpdatePetForm";
	}

	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}/edit", method = {
			RequestMethod.POST, RequestMethod.PUT })
	public String processUpdateForm(@ModelAttribute("pet") Pet pet,
			BindingResult result, SessionStatus status) {
		new PetValidator().validate(pet, result);
		if (result.hasErrors()) {
			return "pets/createOrUpdatePetForm";
		} else {
			this.clinicService.savePet(pet);
			status.setComplete();
			return "redirect:/owners/{ownerId}";
		}
	}
}