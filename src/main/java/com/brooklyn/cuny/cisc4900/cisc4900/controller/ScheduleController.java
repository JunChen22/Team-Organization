package com.brooklyn.cuny.cisc4900.cisc4900.controller;

import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Schedule;
import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Shift;
import com.brooklyn.cuny.cisc4900.cisc4900.service.MapValidationErrorService;
import com.brooklyn.cuny.cisc4900.cisc4900.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewSchedule(@Valid @RequestBody Schedule schedule, BindingResult result, Principal principal) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Schedule newSchedule = scheduleService.save(schedule,principal.getName());
        return new ResponseEntity<Schedule>(newSchedule, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Shift> getAllSchedule(Principal principal) {
        return scheduleService.getAll(principal.getName());
    }

    @GetMapping("/{id}")
    public Shift getScheduleByid(@PathVariable int id,Principal principal) {
        return scheduleService.getShiftById(id,principal.getName());
    }

    @DeleteMapping("/{shiftId}/")
    public ResponseEntity<String> deleteScheduleById(@PathVariable int shiftId,Principal principal) {
        scheduleService.deleteShiftByEmpId(shiftId,principal.getName());
        return new ResponseEntity<String>(shiftId + " was successfully deleted", HttpStatus.OK);
    }
}
