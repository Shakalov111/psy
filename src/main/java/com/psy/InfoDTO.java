package com.psy;

import java.time.LocalDate;


public class InfoDTO {
    private String clientFirstName;
    private String clientLastName;
    private String psychologistName;
    private String meetingPlatform;
    private String prepayment;
    private String sessionPackage;
    private String topic;
    private int expirience;
    private String clinicAdress;
    private LocalDate date;
    private String clinicPhoneNumber;


    // Constructor
    public InfoDTO(String clientFirstName, String clientLastName, String psychologistName, String meetingPlatform, String prepayment,String sessionPackage, String topic, int expirience, String clinicAdress, String clinicPhoneNumber, LocalDate date){
        this.topic = topic;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.psychologistName = psychologistName;
        this.meetingPlatform =meetingPlatform;
        this.prepayment = prepayment;
        this.sessionPackage = sessionPackage;
        this.date = date;
        this.expirience = expirience;
        this.clinicAdress = clinicAdress;
        this.clinicPhoneNumber = clinicPhoneNumber;


    }

    // Getters and Setters
    public String getClientFirstName() {
        return clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public String getClinicAdress() {
        return clinicAdress;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getExpirience() {
        return expirience;
    }

    public String getMeetingPlatform() {
        return meetingPlatform;
    }

    public String getPrepayment() {
        return prepayment;
    }

    public String getPsychologistName() {
        return psychologistName;
    }

    public String getSessionPackage() {
        return sessionPackage;
    }

    public String getTopic() {
        return topic;
    }

    public String getClinicPhoneNumber() {
        return clinicPhoneNumber;
    }
}