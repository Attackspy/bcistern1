package com.example.bcistern.dao;

import com.example.bcistern.model.Review;
import com.example.bcistern.model.ReviewKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, ReviewKey> {
    @Query("select r.rating from Review r where r.course.id = ?1")
    Optional<List<Integer>> getRatings(Long cid);
}
