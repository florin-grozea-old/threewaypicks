package com.threewaypicks.repository;

import com.threewaypicks.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/3/12
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends PagingAndSortingRepository<User, String>{

}
