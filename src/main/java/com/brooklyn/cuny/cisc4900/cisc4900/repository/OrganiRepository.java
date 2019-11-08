package com.brooklyn.cuny.cisc4900.cisc4900.repository;

import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Employee;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganiRepository extends JpaRepository<Organization, Integer> {

    Organization findByOrgName(String name);
    Organization findByCreateBy(String name);
    Organization findByEmployees(Employee employee);
}