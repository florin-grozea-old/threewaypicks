package com.threewaypicks.dao;

import com.threewaypicks.domain.Bet;
import com.threewaypicks.domain.Pick;
import com.threewaypicks.repository.BetRepository;
import com.threewaypicks.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/3/12
 * Time: 12:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class BetDAO extends DaoTemplate<Bet>{
    @Autowired
    private BetRepository repository;

    @Override
    protected PagingAndSortingRepository<Bet, String> getRepository() {
        return repository;
    }

    public Page<Bet> findByStatus(Pick.Status status, Pageable page){
        return repository.findByStatus(status, page);
    }
}
