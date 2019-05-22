/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.evrreports;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.Activator;
import org.openmrs.module.evrreports.reporting.provider.MOH510ReportProvider;
import org.openmrs.module.evrreports.reporting.provider.MOH710ReportProvider;
import org.openmrs.module.evrreports.service.ReportProviderRegistrar;
import org.openmrs.module.evrreports.util.TaskRunnerThread;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
@SuppressWarnings("deprecation")
public class AmrsReportModuleActivator implements Activator {

	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * @see org.openmrs.module.Activator#startup()
	 */
	public void startup() {
		log.info("Starting AMRS Reporting Module");

		// TODO use some classpath or Spring magic to acquire these automatically
		ReportProviderRegistrar.getInstance().registerReportProvider(new MOH710ReportProvider());
		ReportProviderRegistrar.getInstance().registerReportProvider(new MOH510ReportProvider());

	}

	/**
	 * @see org.openmrs.module.Activator#shutdown()
	 */
	public void shutdown() {
		log.info("Shutting down AMRS Reporting Module");

		try {
			TaskRunnerThread.destroyInstance();
		} catch (Throwable throwable) {
			log.warn("problem destroying Task Runner Thread instance", throwable);
		}
	}

}
