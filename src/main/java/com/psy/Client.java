package com.psy;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private int lastName;


    @Column(name = "prepaymant")
    private String prepayment;

     @Column(name = "package")
    private String pack;

    @Column(name = "session_number")
    private int sessionNumber;

    // Getters and Setters
    public int getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getLastName() {
        return lastName;
    }

    public String getPack() {
        return pack;
    }

    public String getPrepayment() {
        return prepayment;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public void setPrepayment(String prepayment) {
        this.prepayment = prepayment;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }
}