package com.teamtwo.trails.accountInformation;

import javax.persistence.*;

@Entity
@Table(name = "account_information")
public class AccountInformationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "dateofbirth")
    private String dateofbirth;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    protected AccountInformationModel(){}

    public AccountInformationModel(long id, String username, String dateofbirth, String height, String weight) {
        this.id = id;
        this.username = username;
        this.dateofbirth = dateofbirth;
        this.height = height;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
