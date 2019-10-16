package com.brooklyn.cuny.cisc4900.cisc4900.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    @GetMapping(value = "/")
    public String home() {
        return "this is homepage";
    }

    @GetMapping(value = "/about")
    public String about() {
        return "at about us";
    }
}
