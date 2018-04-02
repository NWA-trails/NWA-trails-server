package com.teamtwo.trails.emergencyContact;


import javax.persistence.*;


@Entity
@Table(name = "emergency_contact")
public class EmergencyContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "contactname")
    private String contactName;


    @Column(name = "primaryphone")
    private String primaryPhone;

    @Column(name = "secondaryphone")
    private String secondaryPhone;

    @Column(name = "username")
    private String username;



    protected EmergencyContactModel(){}

    public EmergencyContactModel(long id, String contactName, String primaryPhone, String secondaryPhone, String username) {
        this.id = id;
        this.contactName = contactName;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.username = username;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getContactName() { return contactName;}

    public void setContactName(String name) { this.contactName = name;}

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) { this.primaryPhone = primaryPhone;}

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

}
