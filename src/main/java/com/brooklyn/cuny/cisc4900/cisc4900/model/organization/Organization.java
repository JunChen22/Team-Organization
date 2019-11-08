package com.brooklyn.cuny.cisc4900.cisc4900.model.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorganization")
    private int idorganization;

    @Column(name = "orgName")
    @NotBlank(message = "organization name can not be empty")
    private String orgName;

    @Column(name = "description")
    private String description;

    @Column(name = "createBy")
    private String createBy;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    @Email(message = "Email is invalid")
    @NotBlank(message = "email can not be empty")
    private String email;

    @JsonIgnore
    @Column(name = "createdate")
    private String createDate;

    @JsonIgnore
    @Column(name = "lastUpdate")
    private String lastUpdate;


    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "organization", orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public int getIdorganization() {
        return idorganization;
    }

    public void setIdorganization(int idorganization) {
        this.idorganization = idorganization;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
