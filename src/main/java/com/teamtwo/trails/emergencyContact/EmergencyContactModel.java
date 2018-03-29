package com.teamtwo.trails.emergencyContact;


import javax.persistence.*;


@Entity
@Table(name = "emergency_contact")
public class EmergencyContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "username")
    private String username;

   

    protected EmergencyContactModel(){}

    public EmergencyContactModel(long id, String first_name, String last_name, String phone_number, String username) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
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


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName() { return this.first_name + " " + this.last_name; }


}
