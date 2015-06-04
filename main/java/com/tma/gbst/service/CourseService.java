package com.tma.gbst.service;

import com.tma.gbst.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by P550 on 5/5/2015.
 */
public interface CourseService {
    List<Course> findAll();

    Course save(Course course);

    void delete(Integer id);
}
