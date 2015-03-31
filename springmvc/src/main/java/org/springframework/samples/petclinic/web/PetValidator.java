package org.springframework.samples.petclinic.web;

import org.springframework.samples.petclinic.model.Pet;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class PetValidator {
	public void validate(Pet pet, Errors errors) {
        String name = pet.getName();
        // name validaation
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", "required", "required");
        } else if (pet.isNew() && pet.getOwner().getPet(name, true) != null) {
            errors.rejectValue("name", "duplicate", "already exists");
        }
        
        // type valication
        if (pet.isNew() && pet.getType() == null) {
            errors.rejectValue("type", "required", "required");
        }
        
     // type valication
        if (pet.getBirthDate()==null) {
            errors.rejectValue("birthDate", "required", "required");
        }
    }
}
