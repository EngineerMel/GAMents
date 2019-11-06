package com.gaments.gaments.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(length = 140)
    private String careerInterests;

    @Column
    private Boolean hasMentor;

    @Column
    private Boolean isMentor;

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

    public Boolean getHasMentor() {
        return hasMentor;
    }

    public void setHasMentor(Boolean hasMentor) {
        this.hasMentor = hasMentor;
    }

    public Boolean getMentor() {
        return isMentor;
    }

    public void setMentor(Boolean mentor) {
        isMentor = mentor;
    }

    @JsonIgnore    //tells Jackson to ignore User object in UserProfile
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
