package com.tma.gbst.service;

import com.tma.gbst.model.Team;

import java.util.List;

/**
 * Created by Administrator on 5/19/15.
 */
public interface TeamService {
    List<Team> findAll();

    Team save(Team team);

    void delete(Integer id);
}
