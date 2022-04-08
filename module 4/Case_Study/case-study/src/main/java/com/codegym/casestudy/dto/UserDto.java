package com.codegym.casestudy.dto;

import javax.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty(message = "Tên không được để trống")
    private String username;
    @NotEmpty(message = "Mật khẩu không được để trống")
    private String password;

    public UserDto() {
    }

    public UserDto(@NotEmpty(message = "Tên không được để trống") String username, @NotEmpty(message = "Mật khẩu không được để trống") String password) {
        this.username = username;
        this.password = password;
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
}
