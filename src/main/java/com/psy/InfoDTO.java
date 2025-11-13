package com.psy;

import java.time.LocalDate;


public class InfoDTO {
    private String clientFirstName;
    private String clientLastName;
    private String psychologistName;
    private String meetingPlatform;
    private String prepayment;
    private String topic;
    private int experience;
    private String clinicAdress;
    private LocalDate date;
    private String clinicPhoneNumber;
    private String pack;


    // Constructor
    public InfoDTO(String clientFirstName, String clientLastName, String psychologistName, String meetingPlatform, String prepayment,String pack, String topic, int experience, String clinicAdress, String clinicPhoneNumber, LocalDate date){
        this.topic = topic;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.psychologistName = psychologistName;
        this.meetingPlatform =meetingPlatform;
        this.prepayment = prepayment;
        this.pack = pack;
        this.date = date;
        this.experience = experience;
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

    public int getExperience() {
        return experience;
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

    public String getpack() {
        return pack;
    }

    public String getTopic() {
        return topic;
    }

    public String getClinicPhoneNumber() {
        return clinicPhoneNumber;
    }

}