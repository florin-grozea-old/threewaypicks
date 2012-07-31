package com.threewaypicks.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 7/18/12
 * Time: 1:53 PM
 */
public class Bet {
    private User user;

    @Valid
    @NotEmpty
    private List<Pick> pickList;

    @NotEmpty
    private String bookMaker;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer stake;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBookMaker() {
        return bookMaker;
    }

    public void setBookMaker(String bookMaker) {
        this.bookMaker = bookMaker;
    }

    public Integer getStake() {
        return stake;
    }

    public void setStake(Integer stake) {
        this.stake = stake;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Pick> getPickList() {
        return pickList;
    }

    public void setPickList(List<Pick> pickList) {
        this.pickList = pickList;
    }

}
