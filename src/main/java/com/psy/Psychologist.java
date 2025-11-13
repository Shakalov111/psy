package com.psy;

import javax.persistence.*;

@Entity
@Table(name = "psychologist")
public class Psychologist {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psychologistId;

    @Column(name = "name")
    private String name;

    @Column(name = "experience")
    private int experience;

     @Column(name = "meeting_platform")
    private String meetingPlatform;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    // Getters and Setters
    public int getPsychologistId() {
        return psychologistId;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getMeetingPlatform() {
        return meetingPlatform;
    }

    public int getClinic() {
        return clinic.getClinicId();
    }

    public void setPsychologistId(int psychologistId) {
        this.psychologistId = psychologistId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setExperience(int experiece) {
        this.experience = experiece;
    }

    public void setMeetingPlatform(String meetingPlatform) {
        this.meetingPlatform = meetingPlatform;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
}