package com.threewaypicks.controller;

import com.threewaypicks.domain.User;
import com.threewaypicks.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/6/12
 * Time: 8:54 PM
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    protected static Logger logger = Logger.getLogger( AdminController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/users", "/users/"}, method = RequestMethod.GET)
    public String showUsers(Model model) {
        logger.debug("show users for user with admin rights");
        Page<User> page = userService.findAllUsers();
        model.addAttribute("userList", page.getContent());
        return "users";
    }

    @RequestMapping(value = {"/users/form", "/users/form/"}, method = RequestMethod.GET)
    public String showUserForm(@ModelAttribute("user") User user) {
        logger.debug("show user form for user with admin rights");
        user.setId(null);
        return "userForm";
    }

    @RequestMapping(value = {"/users/form","/users/form/"}, method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindResult, Model model)
    {
        Boolean formHasErrors = false;
        if(bindResult.hasErrors()){
            formHasErrors= true;
        }

        if( user.getPassword().compareTo(user.getCheckPassword()) != 0 ){
            bindResult.addError(new FieldError("user", "checkPassword","These passwords don't match"));
            formHasErrors = true;
        }

        if( user.getEmail().compareTo(user.getCheckEmail()) != 0 ){
            bindResult.addError(new FieldError("user", "checkEmail", "These email addresses don't match."));
            formHasErrors = true;
        }

        if( !user.changeRoles(user.getFormRoles(), null) ){
            formHasErrors =true;
            bindResult.addError( new FieldError( "user", "formRoles", user.getFormRoles(), false, null, null, "Permission error or invalid role."));

        }

        if( formHasErrors ){
            return "userForm";
        }
        else {
            try{
                User result = userService.asAdminAddUser(user);

            } catch ( DuplicateKeyException e){
                bindResult.reject("DuplicateKeyException","User or Email already exist.");
                return "userForm";
            }
            catch (Exception e){
                bindResult.reject("General Exception", e.getClass().toString());
                return "userForm";
            }

            return "redirect:/admin/users";
        }
    }

}
