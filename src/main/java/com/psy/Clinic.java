package com.psy;


import javax.persistence.*;

@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clinicId;

    @Column(name = "city")
    private String city;

    @Column(name ="street")
    private String street;

    @Column(name ="house")
    private String house;

    @Column(name ="phone_number")
    private String phone_number;


    // Getters and Setters
    public int getClinicId() {
        return clinicId;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getPhone_number() {
        return phone_number;
    }

}