package com.threewaypicks.controller;

import com.threewaypicks.domain.Bet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 7/18/12
 * Time: 4:20 PM
 */
@Controller
@RequestMapping("/bets")
public class BetController {

    protected static Logger logger = Logger.getLogger(BetController.class);

    @RequestMapping(value = {"/betForm", "/betForm/"}, method = RequestMethod.GET)
    public String getBetForm(@ModelAttribute("bet") Bet bet) {
        logger.debug("show bet form");
        return "betForm";
    }

    /**
     * <p>Called when the user submits the bet form</p>
     */
    @RequestMapping(value = {"/betForm","/betForm/"}, method = RequestMethod.POST)
    public String onFormSubmit(@Valid @ModelAttribute("bet") Bet bet, BindingResult result)
    {
        return "redirect:/";
    }

    @RequestMapping(value = {"/pickFormTag/{index}", "/pickFormTag/{index}/"}, method = RequestMethod.GET)
    public String getPickForm(@ModelAttribute("bet") Bet bet, @PathVariable("index") String index, Model model) {
        logger.debug("show bet form");
        model.addAttribute("index",index);
        return "pickFormTag";
    }

}
