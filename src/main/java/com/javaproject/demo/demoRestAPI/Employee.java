package com.javaproject.demo.demoRestAPI;
import javax.annotation.processing.Generated;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {
    public Employee(){}
    public Employee(int id,String firstName,String lastName,int pin,String mobile,int salary,boolean active){
        this.firstName=firstName;
        this.lastName=lastName;
        this.pin=pin;
        this.mobile=mobile;
        this.salary=salary;
        this.active=active;
    }
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=1;
    @Column(name="firstname")
    private String firstName="";

    @Column(name="lastname")
    private String lastName="";

    @Column(name="pin")
    private int pin=0;

    @Column(name="mobile")
    private String mobile="";

    @Column(name="salary")
    private int salary=0;

    @Column(name="active_status")
    private boolean active=true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
