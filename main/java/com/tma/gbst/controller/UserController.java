package com.tma.gbst.controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import com.tma.gbst.model.Role;
import com.tma.gbst.model.Team;
import com.tma.gbst.model.User;
import com.tma.gbst.service.TeamService;
import com.tma.gbst.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Nghi Tran on 4/21/2015.
 */

@Controller
@RequestMapping(value = "/protected/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
     public ModelAndView welcome () {
        return new ModelAndView("userList");
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET, headers = "Accept=application/json")
     public @ResponseBody
     String listUsersJson() throws JSONException {
        JSONArray userArray = new JSONArray();

        // add only one team array to userJSON[0]
        JSONArray teamArray = new JSONArray();
        for (Team team : teamService.findAll()) {
            JSONObject teamJson = new JSONObject();
            try {
                //teamJson.put("id", team.getId());
                Integer s = team.getId();

                teamJson.put("name", team.getName());
                teamJson.put("id", team.getId());
                teamArray.put(teamJson);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        boolean allowArray0 = true;
        for (User user : userService.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", user.getId());
            userJSON.put("name", user.getName());
            userJSON.put("email", user.getEmail());

            // just at userJSON[0]
            if(allowArray0) {
                userJSON.put("teams", teamArray);
                allowArray0 = false;
            }

            userArray.put(userJSON);
        }
        return userArray.toString();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody String newUser) {
        try {
            //set user variables
            JSONObject userJSON = new JSONObject(newUser);
            User user = new User();
            int id = Integer.parseInt(userJSON.getString("id"));
            if(id != 0) {
                user.setId(id);
                System.out.println(user.getId());
            }
            user.setEmail(userJSON.getString("email"));
            user.setName(userJSON.getString("name"));
            user.setEnabled("YES");
            user.setPassword("123");
            user.setRole(Role.ROLE_USER);

            //set team variable
            Team t = new Team();
            int teamId = Integer.parseInt(userJSON.getString("teamId"));
            t.setId(teamId);
            // find team have teamId == id in team table
            for(Team teamInTable : teamService.findAll()){
                if ((teamInTable.getId() == teamId)){
                    t.setName(teamInTable.getName());
                }
            }
            t.setProjectInformation(null);
            t.setProject(null);

            // JPA add user to user table. Add team to team table
            t.getUsers().add(user);
            user.getTeams().add(t);

            // save user using JPA mapping of User to mutual table
            User check = userService.save(user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "redirect:/protected/user";
    }

    @RequestMapping(value = "/deleteUser/{userId}", method=RequestMethod.DELETE)
    public @ResponseBody void deleteUser(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView welcome() {
//        return new ModelAndView("team");
//    }
//
//    @RequestMapping(value = "/teamList", method = RequestMethod.GET)
//    public @ResponseBody String listTeams() {
//        JSONArray teamArray = new JSONArray();
//        for (Team team : teamService.findAll()) {
//            JSONObject teamJson = new JSONObject();
//            try {
//                teamJson.put("id", team.getId());
//                teamJson.put("name", team.getName());
//                teamArray.put(teamJson);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return teamArray.toString();
//    }
}
