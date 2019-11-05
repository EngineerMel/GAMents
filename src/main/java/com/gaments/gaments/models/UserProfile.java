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
    private String emailAddress;

    @Column
    private String careerInterests;


}
