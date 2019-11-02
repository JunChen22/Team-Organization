package com.brooklyn.cuny.cisc4900.cisc4900.controller;

import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Employee;
import com.brooklyn.cuny.cisc4900.cisc4900.model.organization.Organization;
import com.brooklyn.cuny.cisc4900.cisc4900.model.schedule.Schedule;
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

    @GetMapping("/")
    public void getOrganization(Principal principal){

    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewOrganization(@Valid @RequestBody Organization organization, BindingResult result, Principal principal) {
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee, BindingResult result, Principal principal) {
        return new ResponseEntity<>("employee added", HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeEmployee(@Valid @RequestBody Employee employee, BindingResult result, Principal principal) {
        return new ResponseEntity<>("employee removed", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteorganization")
    public ResponseEntity<String>  deleteOrganization(Principal principal) {
        return new ResponseEntity<>("Organization Successfully deleted", HttpStatus.CREATED);
    }
}
