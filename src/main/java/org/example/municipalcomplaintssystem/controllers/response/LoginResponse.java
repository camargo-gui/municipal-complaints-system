package org.example.municipalcomplaintssystem.controllers.response;

public class LoginResponse {
    private String email;
    private String token;

    public LoginResponse(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String toJSON() {
        return "{\"email\":\"" + email + "\",\"token\":\"" + token + "\"}";
    }
}
