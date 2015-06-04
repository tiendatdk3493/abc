package com.tma.gbst.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "User_Course",
            joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "courseId", referencedColumnName = "id")})
    private Set<User> users = new HashSet<User>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Course_Subject",
            joinColumns = {@JoinColumn(name = "courseId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subjectId", referencedColumnName = "id")})
    private Set<Subject> subjects = new HashSet<Subject>();

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


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
}
