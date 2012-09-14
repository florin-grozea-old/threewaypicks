package com.threewaypicks.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 7/18/12
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */

@Document
public class User {
    public enum Role {
        TRIAL, TIPSTER, ADMIN, SUPER_ADMIN
    }

    @Id
    private String id;

    @NotEmpty @Min(5) @Max(15)
    @Indexed(unique = true)
    private String userName;

    @Min(5) @Max(20)
    private String password;

    @Transient
    private String rPassword;

    private List<Role> roles;

    @Email @NotEmpty
    @Indexed(unique = true)
    private String email;

    @Transient
    private String rEmail;

    @Transient
    private String formRoles;

    public String getFormRoles() {
        return formRoles;
    }

    public void setFormRoles(String formRoles) {
        this.formRoles = formRoles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword;
    }

    public String getrEmail() {
        return rEmail;
    }

    public void setrEmail(String rEmail) {
        this.rEmail = rEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
