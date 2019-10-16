package com.brooklyn.cuny.cisc4900.cisc4900.service;

import com.brooklyn.cuny.cisc4900.cisc4900.exceptions.ShiftIdException;
import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Shift;
import com.brooklyn.cuny.cisc4900.cisc4900.model.user.User;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.ShiftRepository;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ShiftRepository shiftRepo;

    @Autowired
    private UserRepository userRepo;

    public Shift save(Shift shift,String username) {
        //theres couple exception here
        User user = userRepo.findByUsername(username);
        shift.setUser(user);
        return shiftRepo.save(shift);
    }

    public Iterable<Shift> getAll() {
        return shiftRepo.findAll();
    }

    //not done
    public Shift getShiftById(int empId, int id) {
        Iterable<Shift> shifts = shiftRepo.findAllByEmployeeId(empId);

        if (shifts == null) {
            throw new ShiftIdException("notthing found");
        }

        return shiftRepo.findById(id);
    }

    public Iterable<Shift> getAllShiftById(int empId) {
        Iterable<Shift> shifts = shiftRepo.findAllByEmployeeId(empId);

        if (shifts == null) {
            throw new ShiftIdException("notthing found");
        }

        return shifts;
    }

    public void deleteShiftByEmpId(int empId,int shiftId) {
        Shift shift = shiftRepo.findByEmployeeId(empId);
        if (shift == null) {
            throw new ShiftIdException(empId + " found was not found");
        }
        shiftRepo.deleteByEmployeeId(empId);
    }
}
