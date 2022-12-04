package com.currency.monitor.entities.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDto {

    @NotEmpty(message = "User's name cannot be empty.")
    @Size(min = 5, max = 20)
    private String username;

    @NotEmpty
    @NotNull
    private String password;

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

}
