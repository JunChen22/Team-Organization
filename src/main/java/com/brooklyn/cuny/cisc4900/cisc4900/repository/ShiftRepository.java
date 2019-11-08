package com.brooklyn.cuny.cisc4900.cisc4900.repository;

import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Shift;
import com.brooklyn.cuny.cisc4900.cisc4900.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends CrudRepository<Shift, Integer> {

    Iterable<Shift> findAllByUser(User user);
    Shift findById(int shiftId);


    //currently is used with use id
    //Iterable<Shift> findAllByEmployeeId(int empId);

    //employee id
    //Shift findByEmployeeId(int empId);

    //void deleteByEmployeeId(int empId);
}
