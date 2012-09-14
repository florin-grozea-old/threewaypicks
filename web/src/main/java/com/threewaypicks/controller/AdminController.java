package com.threewaypicks.controller;

import com.threewaypicks.domain.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    protected static Logger logger = Logger.getLogger( AdminController.class);

    @RequestMapping(value = {"/users", "/users/"}, method = RequestMethod.GET)
    public String showUsers() {
        logger.debug("show users for user with admin rights");
        return "users";
    }

    @RequestMapping(value = {"/users/form", "/users/form/"}, method = RequestMethod.GET)
    public String showUserForm(@ModelAttribute("user") User user) {
        logger.debug("show user form for user with admin rights");
        return "userForm";
    }

    @RequestMapping(value = {"/users/form","/users/form/"}, method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindResult, Model model)
    {
        if(!bindResult.hasErrors()){
            //betService.addBet(bet);
            return "redirect:/admin/users";
        }

        model.addAttribute("user", user);
        return "userForm";

    }

}
