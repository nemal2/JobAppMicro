package com.nemal.JobAppMicro.review.service;

import com.nemal.JobAppMicro.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(Long companyId);
}
