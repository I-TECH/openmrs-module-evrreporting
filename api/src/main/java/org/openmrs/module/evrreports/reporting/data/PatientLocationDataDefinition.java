package org.openmrs.module.evrreports.reporting.data;

import org.openmrs.Encounter;
import org.openmrs.module.evrreports.MOHFacility;
import org.openmrs.module.reporting.data.BaseDataDefinition;
import org.openmrs.module.reporting.data.person.definition.PersonDataDefinition;
import org.openmrs.module.reporting.definition.configuration.ConfigurationPropertyCachingStrategy;
import org.openmrs.module.reporting.evaluation.caching.Caching;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;

/**
 * The last Encounter at a facility
 */
@Caching(strategy=ConfigurationPropertyCachingStrategy.class)
public class PatientLocationDataDefinition extends BaseDataDefinition implements PersonDataDefinition {

	@Override
	public Class<?> getDataType() {
		return String.class;
	}
}
