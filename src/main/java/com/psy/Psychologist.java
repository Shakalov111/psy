package com.psy;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Psychologist {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psychologistId;

    @Column(name = "name")
    private String name;

    @Column(name = "expiriece")
    private int expiriece;

     @Column(name = "meeting_platform")
    private int meetingPlatform;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private int clinicId;

    // Getters and Setters
    public int getPsychologistId() {
        return psychologistId;
    }

    public String getName() {
        return name;
    }

    public int getExpiriece() {
        return expiriece;
    }

    public int getMeetingPlatform() {
        return meetingPlatform;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setPsychologistId(int psychologistId) {
        this.psychologistId = psychologistId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setExpiriece(int expiriece) {
        this.expiriece = expiriece;
    }

    public void setMeetingPlatform(int meetingPlatform) {
        this.meetingPlatform = meetingPlatform;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }
}