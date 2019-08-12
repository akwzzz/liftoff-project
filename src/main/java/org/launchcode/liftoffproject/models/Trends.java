package org.launchcode.liftoffproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Trends {
    //fields
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToMany
    private List<Food> foods;

    @ManyToMany
    private List<Exercise> exercises;

    @ManyToMany
    private List<Sleep> sleep;

    @ManyToMany List<Wellness> wellness;

    public void addItem(Food item) {
        foods.add(item);
    }

    public void addItem(Exercise item) {
        exercises.add(item);
    }

    public void addItem(Sleep item) { sleep.add(item); }

    public void addItem(Wellness item) { wellness.add(item); }





    //constructors
    public Trends(String name) {
        this.name = name;
    }

    public Trends() { }




    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Sleep> getSleeps() {
        return sleep;
    }

    public void setSleeps(List<Sleep> sleeps) {
        this.sleep = sleep;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Wellness> getWellness() { return wellness; }

    public void setWellness(List<Wellness> wellness) { this.wellness = wellness; }
}
