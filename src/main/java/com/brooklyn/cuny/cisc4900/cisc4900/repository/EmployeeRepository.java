package com.brooklyn.cuny.cisc4900.cisc4900.repository;

import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Employee;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findAllByOrganization(Organization organization);
    Employee findByEmail(String email);
}
