package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
@Entity
public class Wellness {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, message = "Score must not be empty")
    private String score;

    @NotNull
    @Size(min=1, message = "Date must not be empty")
    private String date;


    public Wellness(String score, String date) {
        this.score = score;
        this.date = date;
    }

    public Wellness() { }

    public int getId() {
        return id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
