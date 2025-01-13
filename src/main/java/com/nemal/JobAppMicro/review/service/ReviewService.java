package com.nemal.JobAppMicro.review.service;

import com.nemal.JobAppMicro.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long rid);

    boolean updateReview(Long companyId, Long rid ,Review review);

    boolean deleteReview(Long companyId, Long rid);
}
