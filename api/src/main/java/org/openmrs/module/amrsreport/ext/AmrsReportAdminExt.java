package org.openmrs.module.amrsreport.ext;

import org.openmrs.module.web.extension.AdministrationSectionExt;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: oliver
 * Date: 5/30/12
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class AmrsReportAdminExt extends AdministrationSectionExt {
    /** Defines the privilege required to the see the Administration section for the module */
    public String getRequiredPrivilege() {
        return "";
    }
    /* (non-Javadoc)
      * @see org.openmrs.module.web.extension.AdministrationSectionExt#getLinks()
      */
    @Override
    public Map<String, String> getLinks() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("module/amrsreport/mohRender.form", "Open the render");

        return map;
    }

    /* (non-Javadoc)
      * @see org.openmrs.module.web.extension.AdministrationSectionExt#getTitle()
      */
    @Override
    public String getTitle() {
        return "AMRS Report Module";
    }

}
