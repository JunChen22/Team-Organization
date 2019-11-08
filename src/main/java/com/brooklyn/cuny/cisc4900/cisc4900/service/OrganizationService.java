package com.brooklyn.cuny.cisc4900.cisc4900.service;

import com.brooklyn.cuny.cisc4900.cisc4900.exceptions.Organization.OrganizationAlreadyExistException;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Employee;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.EmployeeRepository;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.OrganiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrganizationService {

    @Autowired
    OrganiRepository organizationRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    public Organization saveOrganization(Organization newOrganization,String username) {

        Organization existingOrganization = organizationRepo.findByOrgName(newOrganization.getOrgName());
        if(existingOrganization!=null){
            throw new OrganizationAlreadyExistException("orgName:" + newOrganization.getOrgName() + " already exist");
        }

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            //set create time and modify time
            newOrganization.setCreateBy(username);
            newOrganization.setCreateDate(dateFormat.format(date));
            newOrganization.setLastUpdate(dateFormat.format(date));
            return organizationRepo.save(newOrganization);
        } catch (Exception e) {
            throw new OrganizationAlreadyExistException("orgName:" + newOrganization.getOrgName() + " already exist");
        }
    }

    public Organization getOrganization(String username){
        Organization organization = organizationRepo.findByCreateBy(username);

        if(organization ==null){
            Employee employee = employeeRepo.findByEmail(username);
            organization = organizationRepo.findByEmployees(employee);
        }

        return organization;
    }

}
