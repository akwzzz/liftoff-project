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

    @ManyToMany(mappedBy = "sleep", cascade = {CascadeType.ALL})
    private List<Trends> trends;

    public Sleep(String duration) {
        this.duration = duration;
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
}
