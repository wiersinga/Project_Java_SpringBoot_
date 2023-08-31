package com.testsring.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
//@Entity afin qu'elle soit scannée et prise en compte
public class Client {
    @Id
    //annotez l'attribut id avec @Id et @GeneratedValue afin qu'il soit identifié en tant que clé unique autogénérée.
    private Integer id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String drivinglicenseNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDrivinglicenseNumber() {
        return drivinglicenseNumber;
    }

    public void setDrivinglicenseNumber(String drivinglicenseNumber) {
        this.drivinglicenseNumber = drivinglicenseNumber;
    }


    //    public Client(int id, String name, String lastName, Date birthDate, String drivinglicenseNumber) {
//
//        this.id = id;
//        this.name = name;
//        this.lastName = lastName;
//        this.birthDate = birthDate;
//        this.drivinglicenseNumber = drivinglicenseNumber;
//    }

//    public Client() {
//
//    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", drivinglicenseNumber='" + drivinglicenseNumber + '\'' +
                '}';
    }
}


