package com.example.bcistern.dao;

import com.example.bcistern.model.Review;
import com.example.bcistern.model.ReviewKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, ReviewKey> {
}
