package com.tma.gbst.model;

import javax.persistence.*;

/**
 * Created by ntnngoc on 4/23/2015.
 */
@Entity
public class Report {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;
    private String todayWork;
    private String issue;
    @ManyToOne
    @JoinColumn(name = "teamId", referencedColumnName = "id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodayWork() {
        return todayWork;
    }

    public void setTodayWork(String todayWork) {
        this.todayWork = todayWork;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
