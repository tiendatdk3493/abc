package com.tma.gbst.service.impl;

import com.tma.gbst.model.Team;
import com.tma.gbst.repository.MyBaseRepository;
import com.tma.gbst.repository.TeamRepository;
import com.tma.gbst.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 5/19/15.
 */

@Service
public class TeamServiceImp implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void delete(Integer id) {
        teamRepository.delete(teamRepository.findOne(id));
    }
}
