package com.brooklyn.cuny.cisc4900.cisc4900.repository;

import com.brooklyn.cuny.cisc4900.cisc4900.model.user.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByRole(String role);
}
