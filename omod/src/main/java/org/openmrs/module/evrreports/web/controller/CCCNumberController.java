package org.openmrs.module.evrreports.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.PatientIdentifierType;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.evrreports.AmrsReportsConstants;
import org.openmrs.module.evrreports.MOHFacility;
import org.openmrs.module.evrreports.service.MOHFacilityService;
import org.openmrs.module.evrreports.service.UserFacilityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Controller for facility management pages
 */
@Controller
@RequestMapping("module/evrreports/cccNumbers.list")
public class CCCNumberController {

	private final Log log = LogFactory.getLog(getClass());

	@ModelAttribute("productionServerURL")
	public String getProductionServerURL() {
		return Context.getAdministrationService().getGlobalProperty(AmrsReportsConstants.GP_PRODUCTION_SERVER_URL);
	}

	@ModelAttribute("cccIdentifierTypeUuid")
	public String getCCCIdentifierTypeUuid() {
		String identifierTypeId = Context.getAdministrationService()
				.getGlobalProperty(AmrsReportsConstants.GP_CCC_NUMBER_IDENTIFIER_TYPE);
		try {
			PatientIdentifierType pit = Context.getPatientService().getPatientIdentifierType(Integer.parseInt(identifierTypeId));
			return pit.getUuid();
		} catch (NumberFormatException e) {
			log.error("Could not get CCC identifier type: " + identifierTypeId, e);
			return null;
		}
	}

	@ModelAttribute("facilities")
	public List<Location> getAllFacilities() {

        User currentUser = Context.getAuthenticatedUser();
        List<Location> relevantFacilities = Context.getService(UserFacilityService.class).getAllowedFacilitiesForUser(currentUser);

		return relevantFacilities;
	}

	@ModelAttribute("serials")
	public Map<Integer, Integer> getLatestSerialNumbers() {
		return Context.getService(MOHFacilityService.class).getFacilityIdToLatestSerialNumberMap();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showFacilities() {
		return "module/evrreports/cccNumbers";
	}

}
