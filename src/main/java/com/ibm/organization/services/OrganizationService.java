package com.ibm.organization.services;

import com.ibm.organization.model.Organization;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    public Organization getOrg(String organizationId) {
       Organization org = new Organization();
       org.setId("f16b3bb8-3c47-4ae4-93f2-ca4914909e99");
       org.setContactEmail("a@a.com");
       org.setContactName("CN");
       org.setContactPhone("xxx-xx-xxxxx");
       org.setName("ON");
       return org;
    }
}
