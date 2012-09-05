package com.threewaypicks.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String showMainAdminPage() {
        logger.debug("show bet form");
        return "adminOptions";
    }

}
