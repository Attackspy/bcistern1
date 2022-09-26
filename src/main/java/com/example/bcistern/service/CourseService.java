package com.example.bcistern.service;

import com.example.bcistern.dao.CourseRepository;
import com.example.bcistern.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> showCourse(){
        List<Course> liste = courseRepository.findAll();
        liste.sort(Comparator.comparing(Course::getRating));
        Collections.reverse(liste);
        return liste;
    }

    public void addNewCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(@RequestParam Long id) {courseRepository.deleteById(id);}

    public void activateCourse(@RequestParam Long id) {
        courseRepository.activateCourse(id);
    }

    public Optional<Course> findcourse(@RequestParam Long id) {
        return courseRepository.findById(id);
    }

    public void deactivateCourse(@RequestParam Long id) { courseRepository.deactivateCourse(id);}
}
