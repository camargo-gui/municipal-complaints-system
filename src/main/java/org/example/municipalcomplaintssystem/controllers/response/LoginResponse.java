package org.example.municipalcomplaintssystem.controllers.response;

public class LoginResponse {
    private int role;
    private String token;

    public LoginResponse(int role, String token) {
        this.role = role;
        this.token = token;
    }

    public String toJSON() {
        return "{\"role\":\"" + role + "\",\"token\":\"" + token + "\"}";
    }
}
