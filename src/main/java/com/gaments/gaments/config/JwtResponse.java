package com.gaments.gaments.config;

public class JwtResponse {

    private String jwt;

    public JwtResponse(String jwyt){
        this.jwt = jwt;
    }

    public String getToken(){
        return this.jwt;
    }

}
