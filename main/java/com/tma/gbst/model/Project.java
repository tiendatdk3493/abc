package com.tma.gbst.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ntnngoc on 4/23/2015.
 */
@Entity
public class Project {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;
    private String name;
    private String projectInfo;

    @OneToMany(mappedBy = "project")
    private Set<Team> teams = new HashSet<Team>();

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

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }
}
