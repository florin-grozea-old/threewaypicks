package com.threewaypicks.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
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


    @Id
    private String id;

    @NotEmpty @Min(5) @Max(15)
    private String userName;

    @Min(5) @Max(20)
    private String password;

    private List<String> roles;

    @Email @NotEmpty
    private String email;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
