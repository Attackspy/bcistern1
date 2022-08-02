package com.example.bcistern.dao;

import com.example.bcistern.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Modifying
    @Query("update Course set is_active = 0 where id = ?1")
    void activateCourse(long id);
}
