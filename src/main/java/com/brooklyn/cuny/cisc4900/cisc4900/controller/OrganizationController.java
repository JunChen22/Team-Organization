package com.brooklyn.cuny.cisc4900.cisc4900.controller;

import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Employee;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Schedule;
import com.brooklyn.cuny.cisc4900.cisc4900.service.EmployeeService;
import com.brooklyn.cuny.cisc4900.cisc4900.service.MapValidationErrorService;
import com.brooklyn.cuny.cisc4900.cisc4900.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organiService;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @GetMapping("/")
    public Organization getOrganization(Principal principal){
        return organiService.getOrganization(principal.getName());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewOrganization(@Valid @RequestBody Organization organization, BindingResult result, Principal principal) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        organiService.saveOrganization(organization,principal.getName());
        return new ResponseEntity<>(organization, HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee newEmployee, BindingResult result, Principal principal) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        employeeService.saveOrUpdateEmployee(newEmployee,principal.getName());
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Employee> getAllEmployees(Principal principal) {
        return employeeService.getAllEmployee(principal.getName());
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeEmployee(@Valid @RequestBody Employee employee ,Principal principal) {
        return new ResponseEntity<>("employee: "+employee.getFirstName() +" "+employee.getLastName(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteorganization")
    public ResponseEntity<String>  deleteOrganization(Principal principal) {
        return new ResponseEntity<>("Organization Successfully deleted", HttpStatus.CREATED);
    }
}
