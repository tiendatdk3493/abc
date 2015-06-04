package com.tma.gbst.controller;

import com.tma.gbst.model.Course;
import com.tma.gbst.service.CourseService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nghi Tran on 5/4/2015.
 */
@Controller
@RequestMapping(value = "/protected/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("course");
    }

    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    public @ResponseBody String listCourses() {
        JSONArray courseArray = new JSONArray();
        for (Course course : courseService.findAll()) {
            JSONObject courseJson = new JSONObject();
            try {
                courseJson.put("id", course.getId());
                courseJson.put("name", course.getName());
                courseArray.put(courseJson);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return courseArray.toString();
    }

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public String addCourse(@RequestBody String newCourse) {
        try {
            JSONObject courseJson = new JSONObject(newCourse);
            Course course = new Course();
            int id = Integer.parseInt(courseJson.getString("id"));
            if (id != 0) {
                course.setId(id);
            }
            course.setName(courseJson.getString("name"));
            courseService.save(course);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "redirect:/protected/course";
    }

    @RequestMapping(value = "/deleteCourse/{courseId}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCourse(@PathVariable("courseId") Integer courseId) {
        courseService.delete(courseId);
    }
}
