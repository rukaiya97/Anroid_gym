package com.example.GymSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class trainers {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Address")
    private String Address;

    @Column(name = "Email")
    private String Email;

    @Column(name="Gender")
    private String Gender;
    public trainers(long iD, String name, String address, String email, String gender) {
        ID = iD;
        Name = name;
        Address = address;
        Email = email;
        Gender = gender;
    }
    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }

    

    }
    

