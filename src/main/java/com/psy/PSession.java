package com.psy;

import javax.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "p_session")
public class PSession {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "psychologist_id")
    private Psychologist psychologist;


    @Column(name = "date")
    private LocalDate date;

    @Column(name = "topic")
    private String topic;

    // Getters and Setters
    
    public int getSessionId() {
        return sessionId;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDate() {
        return date;
    }

    public Psychologist getPsychologist() {
        return psychologist;
    }

    public String getTopic() {
        return topic;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPsychologist(Psychologist psychologist) {
        this.psychologist = psychologist;
    }

    public void setTopic(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTopic'");
    }
}
    