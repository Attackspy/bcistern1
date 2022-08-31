package com.example.bcistern.api;

import com.example.bcistern.model.Review;
import com.example.bcistern.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review sendComment(@RequestBody Review review){
        reviewService.makeComment(review);
        return review;
    }

    @RequestMapping(value = "average", method = RequestMethod.GET)
    public Double getAverage(@RequestBody Long cid){
        return reviewService.learnAverage(cid);
    }
}
