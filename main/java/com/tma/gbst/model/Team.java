package com.tma.gbst.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ntnngoc on 4/23/2015.
 */
@Entity
public class Team {
    @Id()
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;
    private String name;
    private String projectInformation;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "team_user", joinColumns = {@JoinColumn(name = "teamId", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")})
    @ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<User>();

    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private Project project;

    @OneToMany(mappedBy = "team")
    private Set<Report> reports = new HashSet<Report>();

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

//    @ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
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

    public String getProjectInformation() {
        return projectInformation;
    }

    public void setProjectInformation(String projectInformation) {
        this.projectInformation = projectInformation;
    }
}
