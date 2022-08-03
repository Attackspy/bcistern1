package com.example.bcistern.api;

import com.example.bcistern.model.Course;
import com.example.bcistern.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @DeleteMapping
    public void deleteCourse(@RequestBody Long id) { courseService.deleteCourse(id);}

    @RequestMapping(value = "activate", method = RequestMethod.PUT)
    public String courseActivate(@RequestBody Long id) {
        Optional<Course> course = courseService.findcourse(id);
        courseService.activateCourse(id);
        return course + "!!";
    }

    @RequestMapping(value = "deactivate", method = RequestMethod.PUT)
    public String courseDeactivate(@RequestBody Long id) {
        Optional<Course> course = courseService.findcourse(id);
        courseService.deactivateCourse(id);
        return course + "!!";
    }
}
