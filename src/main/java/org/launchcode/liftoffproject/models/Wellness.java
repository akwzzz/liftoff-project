package org.launchcode.liftoffproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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

    @ManyToMany(mappedBy = "wellness", cascade = {CascadeType.ALL})
    private List<Trends> trends;

    public Wellness(String score) {
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