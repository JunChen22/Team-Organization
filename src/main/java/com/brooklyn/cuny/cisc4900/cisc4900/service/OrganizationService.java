package com.brooklyn.cuny.cisc4900.cisc4900.service;

import com.brooklyn.cuny.cisc4900.cisc4900.exceptions.OrganizationAlreadyExistException;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.OrganiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrganizationService {

    @Autowired
    OrganiRepository organiRepository;

    public Organization saveOrganization(Organization newOrganization,String username) {

        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            //set create time and modify time
            newOrganization.setCreateBy(username);
            newOrganization.setCreateDate(dateFormat.format(date));
            newOrganization.setLastUpdate(dateFormat.format(date));
            return organiRepository.save(newOrganization);
        } catch (Exception e) {
            throw new OrganizationAlreadyExistException("orgName:" + newOrganization.getOrgName() + " already exist");
        }
    }

}
