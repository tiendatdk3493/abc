package com.tma.gbst.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ntnngoc on 4/23/2015.
 */
@Entity
public class Subject {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;
    private String method;
    private double plannedDuration;
    private String note;
    private String material;
    private String slide;
    @ManyToMany(mappedBy = "subjects")
    private Set<Course> courses = new HashSet<Course>();

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getPlannedDuration() {
        return plannedDuration;
    }

    public void setPlannedDuration(double plannedDuration) {
        this.plannedDuration = plannedDuration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide;
    }
}
