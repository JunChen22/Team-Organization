package com.brooklyn.cuny.cisc4900.cisc4900.model.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "fname")
    private String firstname;

    @Column(name = "lname")
    private String lastname;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @Column(name = "lastUpdate")
    private String lastUpdate;

}
