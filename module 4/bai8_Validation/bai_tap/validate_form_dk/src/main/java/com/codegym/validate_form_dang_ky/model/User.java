package com.codegym.validate_form_dang_ky.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class User {
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min = 5, max = 45, message = "ten phai tu 5 den 45 ki tu")
    private String firstname;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min = 5, max = 45, message = "ten phai tu 5 den 45 ki tu")
    private String lastname;
    @NotEmpty(message = "Phone Number is invalid")
    private String phonenumber;
    @Min(18)
    private int age;
    @Email(message = "Email không hợp lệ")
    private String email;

    public User() {
    }

    public User(@NotEmpty(message = "Khong duoc de trong") @Size(min = 5, max = 45, message = "ten phai tu 5 den 45 ki tu") String firstname, @NotEmpty(message = "Khong duoc de trong") @Size(min = 5, max = 45, message = "ten phai tu 5 den 45 ki tu") String lastname, @NotEmpty(message = "Phone Number is invalid") String phonenumber, @Min(18) int age, @Email(message = "Email không hợp lệ") String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

