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

    public Iterable<Shift> getAll(String username) {
        User user = userRepo.findByUsername(username);

        if(user== null){
            System.out.println("couldnt find the user");
        }
        return shiftRepo.findAllByUser(user);
    }

    //not done
    public Shift getShiftById(int id,String username) {
        Iterable<Shift> shifts = shiftRepo.findAllByEmployeeId(id);

        if (shifts == null) {
            throw new ShiftIdException("notthing found");
        }

        return shiftRepo.findById(id);
    }


    public void deleteShiftByEmpId(int shiftId,String username) {
        Shift shift = shiftRepo.findByEmployeeId(shiftId);
        if (shift == null) {
            throw new ShiftIdException(shiftId + " found was not found");
        }
        shiftRepo.deleteByEmployeeId(shiftId);
    }
}
