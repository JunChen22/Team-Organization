package com.brooklyn.cuny.cisc4900.cisc4900.service;

import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.OrganiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    OrganiRepository organiRepository;

    public void saveOrganization(Organization organization) {
        // organization.s
        organiRepository.save(organization);
    }


    //check for existing organization name
    public boolean isOrgnazationNameExist(Organization Organization) {
        if (organiRepository.findOrganizationByorganizationName(Organization.getOrganizationName()) != null) {
            return true;
        }
        return false;
    }
}
