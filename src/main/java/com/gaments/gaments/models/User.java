package com.gaments.gaments.models;

import javax.persistence.*;


@Entity
@Table(name = "users")          //dictates which database table this model represents
public class User {

    //manages column names and even auto-generate IDs
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToOne(cascade = CascadeType.ALL)        //each user will have only one Profile
    @JoinColumn(name = "user_profile_id")       //creates the foreign key column
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    
}
