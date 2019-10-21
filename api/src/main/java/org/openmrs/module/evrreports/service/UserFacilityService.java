package org.openmrs.module.evrreports.service;

import org.openmrs.Location;
import org.openmrs.User;
import org.openmrs.module.evrreports.MOHFacility;
import org.openmrs.module.evrreports.UserFacility;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for use with {@link UserFacility} objects
 */
public interface UserFacilityService {

	/**
	 * Saves a UserFacility
	 */
	@Transactional
	public UserFacility saveUserFacility(UserFacility userFacility);

	/**
	 * Gets a UserFacility by primary id
	 */
	@Transactional(readOnly = true)
	public UserFacility getUserFacility(Integer userFacilityId);

	/**
	 * Gets all UserFacility objects
	 */
	@Transactional(readOnly = true)
	public List<UserFacility> getAllUserFacilities();

	/**
	 * Purges a UserFacility
	 */
	@Transactional
	public void purgeUserFacility(UserFacility userFacility);

	/**
	 * Gets all Facilities linked to a given User
	 *
	 * @should return an empty list if the user is null
	 */
	@Transactional(readOnly = true)
	public List<Location> getAllowedFacilitiesForUser(User user);

	/**
	 * Returns whether a User has access to the given Facility
	 */
	@Transactional(readOnly = true)
	public Boolean hasFacilityPrivilege(User user, Location facility);
}
