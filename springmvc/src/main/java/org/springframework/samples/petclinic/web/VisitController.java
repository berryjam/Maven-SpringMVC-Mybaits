package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("visit")
public class VisitController {

	private final ClinicService clinicService;

	@Autowired
	public VisitController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/owners/*/pets/{petId}/visits/new", method = RequestMethod.GET)
	public String initNewVisitForm(@PathVariable("petId") int petId,
			Map<String, Object> model) {
		Pet pet = this.clinicService.findPetById(petId);
		Visit visit = new Visit();
		pet.addVisit(visit);
		model.put("visit", visit);
		return "pets/createOrUpdateVisitForm";
	}

	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}/visits/new", method = RequestMethod.POST)
	public String processNewVisitForm(@Valid Visit visit, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		} else {
			this.clinicService.saveVisit(visit);
			status.setComplete();
			return "redirect:/owners/{ownerId}";
		}
	}

	@RequestMapping(value = "/owners/*/pets/{petId}/visits", method = RequestMethod.GET)
	public ModelAndView showVisits(@PathVariable int petId) {
		ModelAndView mav = new ModelAndView("visitList");
		mav.addObject("visits", this.clinicService.findPetById(petId)
				.getVisits());
		return mav;
	}
}
