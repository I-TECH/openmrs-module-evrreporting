/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.evrreports.reporting.cohort.definition;

import org.openmrs.module.reporting.cohort.definition.BaseCohortDefinition;
import org.openmrs.module.reporting.common.Localized;
import org.openmrs.module.reporting.definition.configuration.ConfigurationProperty;
import org.openmrs.module.reporting.definition.configuration.ConfigurationPropertyCachingStrategy;
import org.openmrs.module.reporting.evaluation.caching.Caching;

import java.util.Date;

/**
 * MOH 510 cohort definition
 */
@Caching(strategy = ConfigurationPropertyCachingStrategy.class)
@Localized("reporting.moh510Cohort")
public class VaccinatedClientsCohortDefinition extends BaseCohortDefinition {

    @ConfigurationProperty
    private Date asOfDate;

    @ConfigurationProperty
    private String vaccineTableColumn;

    public VaccinatedClientsCohortDefinition(String tableColumn) {
        this.vaccineTableColumn = tableColumn;
    }

    public Date getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(Date asOfDate) {
        this.asOfDate = asOfDate;
    }

    public String getVaccineTableColumn() {
        return vaccineTableColumn;
    }

    public void setVaccineTableColumn(String vaccineTableColumn) {
        this.vaccineTableColumn = vaccineTableColumn;
    }
}
