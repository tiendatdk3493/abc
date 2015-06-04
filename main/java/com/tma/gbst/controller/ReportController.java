package com.tma.gbst.controller;

import com.tma.gbst.model.Role;
import com.tma.gbst.model.Team;
import com.tma.gbst.model.User;
import com.tma.gbst.model.UserProfile;
import com.tma.gbst.service.UserProfileService;
import com.tma.gbst.service.UserService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by thuynghi on 5/4/2015.
 */
@Controller
@RequestMapping(value = "/protected/report")
public class ReportController {
    @Autowired
    UserService userService;
    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome () {
        return new ModelAndView("report");
    }

    @RequestMapping(value = "/viewInformation", method = RequestMethod.GET)
    public @ResponseBody String processUsers (HttpSession session) {
        List<User> userList = userService.findByRole(Role.ROLE_USER);
        // year experience
        int yearExperiences[] = {0, 0, 0, 0, 0, 0};
        int readiness[] = {0, 0, 0, 0, 0, 0};
        JSONObject json = new JSONObject();

        int numberSize = userList.size();
        int numberIn = 0;
        int numberOut = 0;
        int numberMale = 0;
        int numberFemale = 0;

        for (int i = 0; i < numberSize; i++) {
            if(userList.get(i).getEnabled().equals("YES")) {
                numberIn++;
            }
            else {
                numberOut++;
            }

            UserProfile userProfile= userList.get(i).getUserProfile();
            if (userProfile != null ) {
                if (userProfile.isGender()) {
                    numberMale++;
                } else {
                    numberFemale++;
                }

                Date date = new Date();
                float timeToNow = 0;
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date joinDate = format.parse(userProfile.getJoinDate());
                    timeToNow = ((float)date.getTime() - (float)joinDate.getTime()) / (float)31536000000L;

                    // readiness
                    float timeCalculateByDay = ((float)date.getTime() - (float)joinDate.getTime()) / (float)86400000;
                    if (timeCalculateByDay > 180 || timeCalculateByDay < 0) {
                        readiness[5]++;
                    } else if (timeCalculateByDay > 90) {
                        readiness[4]++;
                    } else if (timeCalculateByDay > 30) {
                        readiness[3]++;
                    } else if (timeCalculateByDay > 14) {
                        readiness[2]++;
                    } else if (timeCalculateByDay > 7) {
                        readiness[1]++;
                    } else if (timeCalculateByDay >= 0) {
                        readiness[0]++;
                    }
                    //----------------------------------------------------------------------
                    // System.out.println(date.getTime() - joinDate.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if((float)userProfile.getExperienceYears()+timeToNow > 5) {
                    yearExperiences[5]++;
                } else if((float)userProfile.getExperienceYears()+timeToNow >3) {
                    yearExperiences[4]++;
                } else if((float)userProfile.getExperienceYears()+timeToNow > 2) {
                    yearExperiences[3]++;
                } else if((float)userProfile.getExperienceYears()+timeToNow > 1) {
                    yearExperiences[2]++;
                } else if((float)userProfile.getExperienceYears()+timeToNow > 0.5) {
                    yearExperiences[1]++;
                } else {
                    yearExperiences[0]++;
                }
            }
        }

        try {
            json.put("size", numberSize);
            json.put("in", numberIn);
            json.put("out", numberOut);
            json.put("male", numberMale);
            json.put("female", numberFemale);
            for (int i = 0; i < 6; i++) {
                json.put("yearExperiences_" + i, yearExperiences[i]);
            }
            for (int i = 0; i < 6; i++) {
                json.put("readiness_" + i, readiness[i]);
            }

            return json.toString();
        } catch (JSONException e) {
            return "";
        }

    }

    @RequestMapping(value = "/getInformationByMonth", params = {"month1", "year1", "month2", "year2"})
    public @ResponseBody String getInformationByMonth (@RequestParam("month1") String month1, @RequestParam("year1") String year1,
                                                       @RequestParam("month2") String month2, @RequestParam("year2") String year2) {

        List<User> userList = userService.findByRole(Role.ROLE_USER);
        JSONArray jsonArray = new JSONArray();

        // return "" if the in put value have problem
        if(Integer.valueOf(month1) > Integer.valueOf(month2) &&
                Integer.valueOf(year1) == Integer.valueOf(year2)){
            return "";
        }

        // report data for period 12 months
        int runYear = Integer.valueOf(year1);
        int runMonth;
        for(runMonth = Integer.parseInt(month1); runMonth <= 12; runMonth++){
            JSONObject jsonObject = new JSONObject();
            String yearMonth = "";
            int poolSize = 0;
            int inMembersByMonth = 0;
            int outMembersByMonth = 0;
            int numberMaleByMonth = 0;
            int numberFemaleByMonth = 0;

            // convert to Year-Month
            yearMonth = String.valueOf(runYear)+"-";
            if(runMonth < 10){
                yearMonth += "0";
            }
            yearMonth += String.valueOf(runMonth);

            // get in members male, female and pool size each month
            for (int i = 0; i < userList.size(); i++) {
                User oneUser = userList.get(i);
                UserProfile userProfile = oneUser.getUserProfile();
                Set<Team> teamSet = oneUser.getTeams();

                // pool size in, out members, male, female
                if (userProfile != null ) {
                    if (userProfile.getJoinDate().startsWith(yearMonth)) {
                        // pool Size
                        // loop all team set for each team if team name Equal Pool,pool poolSize++
                        // with outDate before this month
                        // notice case outDate empty
                        Iterator<Team> itr = teamSet.iterator();
                        while(itr.hasNext()){
                            Team oneTeam = itr.next();

                            String outDate = oneUser.getOutDate();
                            // out date is empty
                            if (outDate == null) {
                                if ((oneTeam.getName().equals("Pool") || oneTeam.getName().equals("pool"))) {
                                    poolSize++;
                                }
                            } else { // have out date
                                String[] retVal = outDate.split("-");
                                int outYear = Integer.valueOf(retVal[0]);
                                int outMonth = Integer.valueOf(retVal[1]);
                                if(outYear <= runYear && outMonth <= runMonth){
                                    poolSize++;
                                }
                            }
                        }

                        inMembersByMonth++;

                        if (userProfile.isGender()) {
                            numberMaleByMonth++;
                        } else {
                            numberFemaleByMonth++;
                        }
                    }
                }
            }

            // get pool size

            try {
                jsonObject.put("yearMonth", yearMonth);
                jsonObject.put("poolSize", poolSize);
                jsonObject.put("outMembersByMonth", outMembersByMonth);
                jsonObject.put("inMembersByMonth", inMembersByMonth);
                //jsonObject.put("numberMaleByMonth", numberMaleByMonth);
                //jsonObject.put("numberFemaleByMonth", numberFemaleByMonth);

                // add to jsonArray
                jsonArray.put(jsonObject);

            } catch (JSONException e) {
                return "";
            }

            if((runMonth == Integer.parseInt(month2)) && (runYear == Integer.valueOf(year2))){
                break;
            }
            if(runMonth == 12){
                runMonth = 0;
                runYear++;
            }

        }

        return jsonArray.toString();
    }


}
