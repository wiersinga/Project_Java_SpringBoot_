package com.testsring.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
//@Entity afin qu'elle soit scannée et prise en compte
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //annotez l'attribut id avec @Id et @GeneratedValue afin qu'il soit identifié en tant que clé unique autogénérée.
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String licenseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String drivinglicenseNumber) {
        this.licenseId = drivinglicenseNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", drivinglicenseNumber='" + licenseId + '\'' +
                '}';
    }
}


