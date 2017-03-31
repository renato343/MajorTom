package org.academiadecodigo.bootcamp.roothless.user;

import org.academiadecodigo.bootcamp.roothless.lunarModule.model.utils.Planet;

import java.util.Date;
import java.util.Set;

/**
 * Created by codecadet on 31/03/17.
 */
public class User {
    
    private String username;
    private String password;
    private Set<Planet> planets;
    private Set<Score> houston_scores;
    private Set<Score> spaceship_scores;
    private Set<Date> date_score;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }

    public Set<Score> getHouston_scores() {
        return houston_scores;
    }

    public void setHouston_scores(Set<Score> houston_scores) {
        this.houston_scores = houston_scores;
    }

    public Set<Score> getSpaceship_scores() {
        return spaceship_scores;
    }

    public void setSpaceship_scores(Set<Score> spaceship_scores) {
        this.spaceship_scores = spaceship_scores;
    }

    public Set<Date> getDate_score() {
        return date_score;
    }

    public void setDate_score(Set<Date> date_score) {
        this.date_score = date_score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (planets != null ? !planets.equals(user.planets) : user.planets != null) return false;
        if (houston_scores != null ? !houston_scores.equals(user.houston_scores) : user.houston_scores != null)
            return false;
        if (spaceship_scores != null ? !spaceship_scores.equals(user.spaceship_scores) : user.spaceship_scores != null)
            return false;
        return date_score != null ? date_score.equals(user.date_score) : user.date_score == null;

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (planets != null ? planets.hashCode() : 0);
        result = 31 * result + (houston_scores != null ? houston_scores.hashCode() : 0);
        result = 31 * result + (spaceship_scores != null ? spaceship_scores.hashCode() : 0);
        result = 31 * result + (date_score != null ? date_score.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
