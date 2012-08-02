package com.threewaypicks.service;

import com.threewaypicks.dao.BetDAO;
import com.threewaypicks.domain.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/3/12
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class BetService {
    @Autowired
    private BetDAO betDAO;

    public Bet addBet(Bet bet){
        return betDAO.save(bet);
    }

}
