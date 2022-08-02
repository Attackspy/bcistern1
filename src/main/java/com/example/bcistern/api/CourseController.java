package com.example.bcistern.api;

import com.example.bcistern.model.Course;
import com.example.bcistern.model.User;
import com.example.bcistern.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){this.courseService = courseService;}

    @GetMapping
    public String showCourse(){
        return courseService.showCourse().toString();
    }

    @PostMapping
    public void registerNewCourse(@RequestBody Course course){
        courseService.addNewCourse(course);
    }
}
