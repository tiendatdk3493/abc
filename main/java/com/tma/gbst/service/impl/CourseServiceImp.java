package com.tma.gbst.service.impl;

import com.tma.gbst.model.Course;
import com.tma.gbst.repository.CourseRepository;
import com.tma.gbst.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by P550 on 5/5/2015.
 */
@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.delete(courseRepository.findOne(id));
    }
}
