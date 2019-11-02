package com.brooklyn.cuny.cisc4900.cisc4900.model.schedule;

import com.brooklyn.cuny.cisc4900.cisc4900.model.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "shift")
public class Shift {

    public Shift() {
    }

    public Shift(Shift shift) {
        this.setTitle(shift.getTitle());
        this.setEndTime(shift.getEndTime());
        this.setStartTime(shift.getStartTime());
        this.setDay(shift.getDay());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String day;

    /*
    @NotNull(message = "employee id can not be null")
    @Column(name = "employee_id")
    private int employeeId;
    */

    @NotEmpty(message = " shift name cant be empty")
    private String title;

    //@Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Time startTime;

    //@Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Time endTime;

    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
