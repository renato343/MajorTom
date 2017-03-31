package org.academiadecodigo.bootcamp.roothless.user;

import java.util.Date;

/**
 * Created by codecadet on 31/03/17.
 */
public class User {
    
    private String username;
    private String password;
    private String planet;
    private double score_houston;
    private Date date_score;
    private double score_spaceship;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore_spaceship() {
        return score_spaceship;
    }

    public void setScore_spaceship(double score_spaceship) {
        this.score_spaceship = score_spaceship;
    }

    public Date getDate_score() {
        return date_score;
    }

    public void setDate_score(Date date_score) {
        this.date_score = date_score;
    }

    
    public double getScore_houston() {
        return score_houston;
    }

    public void setScore_houston(double score_houston) {
        this.score_houston = score_houston;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
