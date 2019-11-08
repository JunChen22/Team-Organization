package com.brooklyn.cuny.cisc4900.cisc4900.service;

import com.brooklyn.cuny.cisc4900.cisc4900.exceptions.Organization.EmployeeFormException;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Employee;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.EmployeeRepository;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.OrganiRepository;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmployeeService {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private OrganiRepository organiRepository;

    public Employee saveOrUpdateEmployee(Employee newEmployee, String username) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            //set create time and modify time
            newEmployee.setHireDate(dateFormat.format(date));
            newEmployee.setLastUpdate(dateFormat.format(date));

            Organization organization = organiRepository.findByCreateBy(username);
            newEmployee.setOrganization(organization);
            return employeeRepo.save(newEmployee);
        } catch (Exception e) {
            throw new EmployeeFormException("email:"+newEmployee.getEmail() + " already belong to another organization");
        }
    }

    public Iterable<Employee> getAllEmployee(String username) {

            Employee employee = employeeRepo.findByEmail(username);

            if(employee==null){
                return employeeRepo.findAllByOrganization(organiRepository.findByCreateBy(username));
            }

            Organization organization = employee.getOrganization();
            return employeeRepo.findAllByOrganization(organization);
    }

}

