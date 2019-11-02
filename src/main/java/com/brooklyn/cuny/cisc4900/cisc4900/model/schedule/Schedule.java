package com.brooklyn.cuny.cisc4900.cisc4900.model.schedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String createdBy ;

    private String title;

    @JsonProperty("shifts")
    @ElementCollection
    private Set<Shift> shifts ;

    private int durationWeek;

    private String date;

    @JsonIgnore
    @Column(name = "createDate")
    private String createDate;

    @JsonIgnore
    @Column(name = "lastUpdate")
    private String lastUpdate;

    public int getDurationWeek() {
        return durationWeek;
    }

    public void setDurationWeek(int durationWeek) {
        this.durationWeek = durationWeek;
    }
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(Set<Shift> shifts) {
        this.shifts = shifts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Schedule() {
         this.shifts =new HashSet<>();
    }

    public Schedule(Set<Shift> shifts) {
        this.shifts = shifts;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
