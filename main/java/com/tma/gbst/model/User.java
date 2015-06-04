package com.tma.gbst.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;

    private String email;
    private String name;
    private String enabled;
    private String outDate;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserProfile userProfile;
    @ManyToMany(mappedBy = "users")
    private Set<Course> courses = new HashSet<Course>();

    @ManyToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "team_user", joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "teamId", referencedColumnName = "id")})
    private Set<Team> teams = new HashSet<Team>();

    @OneToMany(mappedBy = "user")
    private Set<Report> reports = new HashSet<Report>();

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}