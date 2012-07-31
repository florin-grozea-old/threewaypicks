package com.threewaypicks.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 7/18/12
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pick {

    public enum Status {
        WON, LOST, VOID, IN_PLAY
    }

    public enum Sport{
       Football,Tennis, Basketball, Others
    }

    @NotNull
    private Sport sport;

    @NotEmpty
    private String league;

    @NotEmpty
    private String Match;

    @NotEmpty
    private String bettingPick;

    @NotNull
    private Double odds;

    @NotNull
    private Status status;

    @NotEmpty
    private String matchTime;

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getMatch() {
        return Match;
    }

    public void setMatch(String match) {
        Match = match;
    }

    public String getBettingPick() {
        return bettingPick;
    }

    public void setBettingPick(String bettingPick) {
        this.bettingPick = bettingPick;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
