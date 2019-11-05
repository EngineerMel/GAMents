package com.gaments.gaments.models;

import javax.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String skills;

    @Column
    private String occupation;

    @Column
    private String email;

    @Column
    private String careerInterests;

    public UserProfile(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills(){
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getOccupation(){
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCareerInterests() {
        return careerInterests;
    }

    public void setCareerInterests(String careerInterests) {
        this.careerInterests = careerInterests;
    }

    @OneToOne(mappedBy = "userProfile", cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
