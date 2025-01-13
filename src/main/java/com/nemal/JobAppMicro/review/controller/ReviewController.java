package com.nemal.JobAppMicro.review.controller;

import com.nemal.JobAppMicro.review.model.Review;
import com.nemal.JobAppMicro.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    ResponseEntity <List<Review>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getReviews(companyId), HttpStatus.OK);
    }
}
