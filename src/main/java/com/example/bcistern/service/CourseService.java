package com.example.bcistern.service;

import com.example.bcistern.dao.CourseRepository;
import com.example.bcistern.model.Course;
import com.example.bcistern.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> showCourse(){
        return courseRepository.findAll();
    }

    public void addNewCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }
}
