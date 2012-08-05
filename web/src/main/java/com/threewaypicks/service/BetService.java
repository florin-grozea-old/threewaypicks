package com.threewaypicks.service;

import com.threewaypicks.dao.BetDAO;
import com.threewaypicks.domain.Bet;
import com.threewaypicks.domain.Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        Double finalOdds = 1D;
        for( Pick pick : bet.getPickList()){
            pick.setStatus(Pick.Status.IN_PLAY);
            finalOdds = finalOdds * pick.getOdds();
        }
        bet.setFinalOdds( finalOdds );
        bet.setDate( new Date());
        bet.setStatus( Pick.Status.IN_PLAY);
        return betDAO.save(bet);
    }

    public Page<Bet> findInPlayBets(){
        // ToDo create a page Class

        Pageable page = new Pageable() {
            @Override
            public int getPageNumber() {
                return 1;
            }

            @Override
            public int getPageSize() {
                return 100;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }
        };

        return betDAO.findByStatus(Pick.Status.IN_PLAY, page);
    }

}
