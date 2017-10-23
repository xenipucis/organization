package com.ibm.organization.controllers;


import com.ibm.organization.model.Organization;
import com.ibm.organization.services.OrganizationService;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationServiceController {
    private OrganizationService orgService;

    @Autowired
    public OrganizationServiceController(final OrganizationService orgService) {
        this.orgService = orgService;
    }


    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceController.class);

    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    public Organization getOrganization( @PathVariable("organizationId") String organizationId) {
        logger.debug(String.format("Looking up data for org {}", organizationId));

        Organization org = orgService.getOrg(organizationId);
        org.setContactName("OLD::" + org.getContactName());
        return org;
    }
    
    @RequestMapping(value = "/headers/toString")
    public String headers(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        Enumeration<String> headerNames= request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
          String name = headerNames.nextElement();
          result.append(name, request.getHeader(name));
      }
     return result.toString();
    }
}
