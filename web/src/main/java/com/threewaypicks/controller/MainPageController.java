package com.threewaypicks.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 7/25/12
 * Time: 10:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainPageController {

    protected static Logger logger = Logger.getLogger( MainPageController.class);

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getBetForm() {
        logger.debug("show bet form");
        return "mainPage";
    }
}
