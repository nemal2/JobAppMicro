package com.nemal.JobAppMicro.review.controller;

import com.nemal.JobAppMicro.review.model.Review;
import com.nemal.JobAppMicro.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/reviews")
    ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isAdded = reviewService.addReview(companyId, review);
        if (isAdded) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Review not added", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{rid}")
    ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long rid) {
        if (reviewService.getReviewById(companyId, rid) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(reviewService.getReviewById(companyId, rid), HttpStatus.OK);
        }
    }

    @PutMapping("/reviews/{rid}")
    ResponseEntity<String> updateReviewById(@PathVariable Long companyId, @PathVariable Long rid, @RequestBody Review review){
        if(!reviewService.updateReview(companyId, rid, review)){
            return new ResponseEntity<>("Not found to update", HttpStatus.NOT_FOUND);

        }else{
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }
    }

    @DeleteMapping("/reviews/{rid}")
    ResponseEntity<String> deleteReviewById(@PathVariable Long companyId, @PathVariable Long rid){
        boolean isDeleted = reviewService.deleteReview(companyId, rid);
        if(isDeleted){
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not found to delete", HttpStatus.NOT_FOUND);
        }
    }

}
