package com.threewaypicks.controller;

import com.threewaypicks.domain.Bet;
import com.threewaypicks.domain.Pick;
import com.threewaypicks.service.BetService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private BetService betService;

    @RequestMapping(value = {"/betForm", "/betForm/"}, method = RequestMethod.GET)
    public String getBetForm(@ModelAttribute("bet") Bet bet) {
        logger.debug("show bet form");
        return "betForm";
    }

    /**
     * <p>Called when the user submits the bet form</p>
     */
    @RequestMapping(value = {"/betForm","/betForm/"}, method = RequestMethod.POST)
    public String onFormSubmit(@Valid @ModelAttribute("bet") Bet bet, BindingResult bindResult, Model model)
    {
        //ToDo clean bindResult errors for deleted picks or
        //ToDo clean picks if they are empty (deleted)
        //Todo or else picks will not be displayed correctly

        if(bet==null || bet.getPickList()== null || bet.getPickList().size() == 0){
            return "betForm";
        }

        //    Clear pick list of null elements that may contains when
        //  a pick is removed from the form.
        List<Pick> picksForRemove = new ArrayList<Pick>();
        for( Pick pick : bet.getPickList()){
            if(pick.getSport() == null ){
                picksForRemove.add(pick);
            }
        }

        bet.getPickList().removeAll( picksForRemove);

        if(!bindResult.hasErrors()){
            betService.addBet(bet);
            return "redirect:/";
        }

        model.addAttribute("bet", bet);
        return "betForm";

    }

    @RequestMapping(value = {"/pickFormTag/{index}", "/pickFormTag/{index}/"}, method = RequestMethod.GET)
    public String getPickForm(@ModelAttribute("bet") Bet bet, @PathVariable("index") String index, Model model) {
        logger.debug("show bet form");
        model.addAttribute("index",index);
        return "pickFormTag";
    }

    /**
     * View current in play bets page
     */
    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public String viewInPlayBets(Model model) {
        Page<Bet> result = betService.findInPlayBets();

        model.addAttribute("betList", result.getContent());
        return "bets";
    }


}
