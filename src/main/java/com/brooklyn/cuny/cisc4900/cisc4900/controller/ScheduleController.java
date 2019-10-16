package com.brooklyn.cuny.cisc4900.cisc4900.controller;

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
    public ResponseEntity<?> createNewSchedule(@Valid @RequestBody Shift shift, BindingResult result, Principal principal) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Shift shift1 = scheduleService.save(shift,principal.getName());
        return new ResponseEntity<Shift>(shift1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Shift> getAllSchedule() {
        return scheduleService.getAll();
    }


    //employee id
    @GetMapping("/{empId}/all")
    public Iterable<Shift> getAllScheduleByEmpid(@PathVariable int empId) {
        return scheduleService.getAllShiftById(empId);
    }

    //not yet implemented fully
    @GetMapping("/{empId}/{id}")
    public ResponseEntity<?> getSchedulebyEmpId(@PathVariable int empId, @PathVariable int id) {
        Shift shift = scheduleService.getShiftById(empId, id);
        return new ResponseEntity<Shift>(shift, HttpStatus.OK);
    }

    @DeleteMapping("/{empId}/")
    public ResponseEntity<String> deleteScheduleByEmpId(@PathVariable int empId,@PathVariable int shiftId) {
        scheduleService.deleteShiftByEmpId(empId,shiftId);
        return new ResponseEntity<String>(empId + " was successfully deleted", HttpStatus.OK);
    }

}
