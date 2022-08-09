package com.example.bcistern.service;

import com.example.bcistern.dao.ReviewRepository;
import com.example.bcistern.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void makeComment(Review review){
        review.setDate_added(LocalDateTime.now());
        reviewRepository.save(review);
    }

    public double learnAverage(Long cid){
        return reviewRepository.getRatings(cid).get().stream().mapToInt(a -> a).average().orElse(0);
    }

    public Optional<List<Review>> seeComments(Long cid){
        return reviewRepository.getComment(cid);
    }
}
