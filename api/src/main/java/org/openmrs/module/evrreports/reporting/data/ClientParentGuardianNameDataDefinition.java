/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.evrreports.reporting.data;

import org.openmrs.module.reporting.data.BaseDataDefinition;
import org.openmrs.module.reporting.data.person.definition.PersonDataDefinition;
import org.openmrs.module.reporting.definition.configuration.ConfigurationProperty;
import org.openmrs.module.reporting.definition.configuration.ConfigurationPropertyCachingStrategy;
import org.openmrs.module.reporting.evaluation.caching.Caching;

/**
 * Visit ID Column
 */
@Caching(strategy=ConfigurationPropertyCachingStrategy.class)
public class ClientParentGuardianNameDataDefinition extends BaseDataDefinition implements PersonDataDefinition {

    public static final long serialVersionUID = 1L;

    @ConfigurationProperty
    private String vaccineTableColumn;

    /**
     * Default Constructor
     */
    public ClientParentGuardianNameDataDefinition() {
        super();
    }

    /**
     * Constructor to populate name only
     */
    public ClientParentGuardianNameDataDefinition(String name) {

        super(name);
    }

    //***** INSTANCE METHODS *****


    public String getVaccineTableColumn() {
        return vaccineTableColumn;
    }

    public void setVaccineTableColumn(String vaccineTableColumn) {
        this.vaccineTableColumn = vaccineTableColumn;
    }

    public ClientParentGuardianNameDataDefinition(String name, String vaccineTableColumn) {
        super(name);
        this.vaccineTableColumn = vaccineTableColumn;
    }

    /**
     * @see org.openmrs.module.reporting.data.DataDefinition#getDataType()
     */
    public Class<?> getDataType() {
        return String.class;
    }
}