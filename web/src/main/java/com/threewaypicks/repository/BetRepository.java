package com.threewaypicks.repository;

import com.threewaypicks.domain.Bet;
import com.threewaypicks.domain.Pick;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/3/12
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public interface BetRepository extends PagingAndSortingRepository<Bet, String>{
    /*@Query("{ 'type' : ?0 , 'mode' : ?1 , 'active' : true }")*/
    @Query("{ 'status' : ?0 }")
    Page<Bet> findByStatus(Pick.Status status, Pageable pageable);
}
