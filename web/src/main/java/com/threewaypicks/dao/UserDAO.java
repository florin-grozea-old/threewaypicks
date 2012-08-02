package com.threewaypicks.dao;

import com.threewaypicks.domain.User;
import com.threewaypicks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/3/12
 * Time: 12:38 AM
 * To change this template use File | Settings | File Templates.
 */


@Component
public class UserDAO extends DaoTemplate<User>{

    @Autowired
    private UserRepository repository;

    @Override
    protected PagingAndSortingRepository<User, String> getRepository() {
        return repository;
    }
}
