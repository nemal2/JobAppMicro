package com.nemal.JobAppMicro.review.service;

import com.nemal.JobAppMicro.review.model.Review;
import com.nemal.JobAppMicro.review.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }
}
