package com.codeclan.example.employeeservice.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    @JsonBackReference
//    @JsonIgnoreProperties({"departments"})
    private List<Employee> listOfEmployees;


    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.listOfEmployees = new ArrayList<>();
    }

    public Department(){

    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getListOfEmployees() {
        return this.listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

}
