package org.launchcode.liftoffproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Sleep {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, message = "Duration must not be empty")
    private String duration;

    @NotNull
    @Size(min=1, message = "Date must not be empty")
    private String date;

    @ManyToMany(mappedBy = "sleep", cascade = {CascadeType.ALL})
    private List<Trends> trends;

    public Sleep(String duration, String date) {
        this.duration = duration;
        this.date = date;
    }

    public Sleep() { }

    public int getId() {
        return id;
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
