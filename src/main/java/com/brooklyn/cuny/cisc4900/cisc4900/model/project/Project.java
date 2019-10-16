package com.brooklyn.cuny.cisc4900.cisc4900.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String projectName;

    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date start_at;

    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date end_at;

    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date created_at;

    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date updated_at;
}
