package com.tma.gbst.controller;

import com.tma.gbst.model.Team;
import com.tma.gbst.service.TeamService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by thuynghi on 5/4/2015.
 */
@Controller
@RequestMapping(value = "/protected/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("team");
    }

    @RequestMapping(value = "/teamList", method = RequestMethod.GET)
    public @ResponseBody String listTeams() {
        JSONArray teamArray = new JSONArray();
        for (Team team : teamService.findAll()) {
            JSONObject teamJson = new JSONObject();
            try {
                teamJson.put("id", team.getId());
                teamJson.put("name", team.getName());
                teamArray.put(teamJson);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return teamArray.toString();
    }

    @RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    public String addTeam(@RequestBody String newTeam) {
        try {
            JSONObject teamJson = new JSONObject(newTeam);
            Team team = new Team();
            int id = Integer.parseInt(teamJson.getString("id"));
            if (id != 0) {
                team.setId(id);
            }
            team.setName(teamJson.getString("name"));
            teamService.save(team);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "redirect:/protected/team";
    }

    @RequestMapping(value = "/deleteTeam/{teamId}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteTeam(@PathVariable("teamId") Integer teamId) {
        teamService.delete(teamId);
    }
}