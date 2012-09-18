package com.threewaypicks.service;

import com.threewaypicks.dao.UserDAO;
import com.threewaypicks.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 9/18/12
 * Time: 4:29 PM
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User asAdminAddUser(User user){
        user.setId(null);
        return userDAO.save(user);
    }

    public Page<User> findAllUsers(){
        return userDAO.findAll( new PageRequest(1,100,0,null) );
    }
}
