package org.launchcode.liftoffproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Duration must not be empty")
    private String duration;

    @NotNull
    @Size(min=1, message = "Date must not be empty")
    private String date;

    @ManyToMany(mappedBy = "exercises", cascade = {CascadeType.ALL})
    private List<Trends> trends;

    public Exercise(String name, String duration, String date) {
        this.name = name;
        this.duration = duration;
        this.date = date;
    }

    public Exercise() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
