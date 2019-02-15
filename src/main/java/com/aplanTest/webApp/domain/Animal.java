package com.aplanTest.webApp.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;

    private Date birthDate;

    private String gender;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

    public Animal() {
    }

    public Animal(String type, Date birthDate, String gender, String name, User owner) {
        this.owner = owner;
        this.type = type;
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = name;
    }

    public String getOwnerName() {
        if (owner != null) {
            return owner.getUsername();
        } else {
            return "no owner";
        }
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
