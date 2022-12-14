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
    @Query("update Course set is_active = 1 where id = ?1")
    void activateCourse(long id);

    @Modifying
    @Query("update Course c set c.is_active = 0 where c.id = ?1")
    void deactivateCourse(long id);

    @Modifying
    @Query("update Course c set c.rating = ?2 where c.id = ?1")
    void updateRating(Long id, double average);
}
