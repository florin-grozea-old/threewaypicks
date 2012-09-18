package com.threewaypicks.domain;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 7/18/12
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */

@Document
public class User {
    protected static Logger logger = Logger.getLogger(User.class);


    public enum Role {
        TRIAL, TIPSTER, ADMIN, SUPER_ADMIN
    }

    @Id
    private String id;

    @Length(max = 15, min = 5)
    @Indexed(unique = true)
    @NotEmpty
    @NotNull
    private String userName;

    @Length(max = 30, min = 6)
    private String password;

    @Transient
    private String checkPassword;

    private Set<Role> roles = new HashSet<Role>();

    @Email
    @Indexed(unique = true)
    @NotEmpty
    @NotNull
    private String email;

    @Transient
    private String checkEmail;

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


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(String checkEmail) {
        this.checkEmail = checkEmail;
    }

    public boolean addRole(Role role, User user) {
        // ToDo: check if the current user can add that role
        this.roles.add(role);
        return true;
    }

    public boolean changeRoles(String roles, User user) {
        // ToDo: check if the current user can add that role
        this.roles = new HashSet<Role>();
        if (StringUtils.isEmpty(roles)) {
            this.roles.add(User.Role.TRIAL);
            return true;
        } else {
            String[] formRoles = roles.split(" ");
            for (String role : formRoles) {
                try {
                    User.Role userRole = User.Role.valueOf(role);
                    this.roles.add(userRole);
                } catch (Exception e) {
                    logger.error( "role error: ", e);
                    return false;
                }
            }
        }
        return true;
    }
}
