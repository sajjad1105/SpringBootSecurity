package com.SpringSecurity.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roll;
    private String branch;
    private String name;
    private long phone;
    private String password;

    public Student() {
        super();
    }

    public Student(int roll, String branch, String name, long phone, String password) {
        this.roll = roll;
        this.branch = branch;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    // Getters and Setters

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
