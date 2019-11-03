package com.brooklyn.cuny.cisc4900.cisc4900.service;

import com.brooklyn.cuny.cisc4900.cisc4900.exceptions.ShiftIdException;
import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Schedule;
import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Shift;
import com.brooklyn.cuny.cisc4900.cisc4900.model.user.User;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.ScheduleRepository;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.ShiftRepository;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.UserRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ShiftRepository shiftRepo;

    @Autowired
    private ScheduleRepository scheduleRepo;

    @Autowired
    private UserRepository userRepo;

    public Schedule save(Schedule schedule, String username) {
        //theres couple exception here
        User user = userRepo.findByUsername(username);

        //set create time and modity time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        schedule.setCreateDate(dateFormat.format(date));
        schedule.setLastUpdate(dateFormat.format(date));

        //add title to each shifts
        for(Shift shift :schedule.getShifts()){
            shift.setTitle(schedule.getTitle());
        }

        for(Shift shift : schedule.getShifts()){
            List<String> dates = getDateByDay(schedule.getDate(),shift.getDay(),schedule.getDurationWeek());
            for(int i = 0;i< schedule.getDurationWeek();i++){
                //create a new shift
                if(i==0){
                    shift.setDate(dates.get(i));
                    shift.setUser(user);
                    shiftRepo.save(shift);
                }else{
                    //copy over
                    Shift newShift = new Shift(shift);
                    newShift.setDate(dates.get(i));
                    newShift.setUser(shift.getUser());
                    shiftRepo.save(newShift);
                }
            }
        }
        return scheduleRepo.save(schedule);
    }


    public static List<String> getDateByDay(String date, String day, int numWeeks){

        int dayOfWeek = -1;
        String[] days = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
        for(int i = 0; i<days.length;i++){
            if(days[i].equals(day)){
                dayOfWeek = i;
            }
        }

        List<String> dates = new ArrayList<>();
        LocalDate startDate = new LocalDate(date);
        LocalDate endDate = startDate.plusWeeks(numWeeks);

        LocalDate weekday = startDate.withDayOfWeek(dayOfWeek);

        if (startDate.isAfter(weekday)) {
            startDate = weekday.plusWeeks(1);
        } else {
            startDate = weekday;
        }

        while (startDate.isBefore(endDate)) {
            dates.add(startDate+"");
            startDate = startDate.plusWeeks(1);
        }

        return dates;
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
        //Iterable<Shift> shifts = shiftRepo.findAllByEmployeeId(id);

        //if (shifts == null) {
         //   throw new ShiftIdException("notthing found");
        //}

        return shiftRepo.findById(id);
    }

    public void deleteShiftByEmpId(int shiftId,String username) {
        //Shift shift = shiftRepo.findByEmployeeId(shiftId);
        //if (shift == null) {
         //   throw new ShiftIdException(shiftId + " found was not found");
        //}
        //shiftRepo.deleteByEmployeeId(shiftId);
    }
}
