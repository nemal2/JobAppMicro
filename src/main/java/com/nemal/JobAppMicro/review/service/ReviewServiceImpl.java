package com.nemal.JobAppMicro.review.service;

import com.nemal.JobAppMicro.company.model.Company;
import com.nemal.JobAppMicro.company.service.CompanyService;
import com.nemal.JobAppMicro.review.model.Review;
import com.nemal.JobAppMicro.review.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReviewById(Long companyId, Long rid) {
        if(companyService.getCompanyById(companyId) != null){
            Company company = companyService.getCompanyById(companyId);
            for (Review review : company.getReviews()) {
                if (review.getRid().equals(rid)) {
                    return review;
                }
            }
        }
        return null;
    }

    @Override
    public boolean updateReview(Long companyId, Long rid, Review review) {
        if(companyService.getCompanyById(companyId) != null){
            if(companyService.getCompanyById(companyId) != null){
                Company company = companyService.getCompanyById(companyId);
                for(Review review1 : company.getReviews() ){
                    if (review1.getRid().equals(rid)){
                        review1.setDescription(review.getDescription());
                        review1.setRating(review.getRating());
                        review1.setTitle(review.getTitle());
                        review1.setCompany(companyService.getCompanyById(companyId));
                        reviewRepository.save(review1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long rid) {
        if(companyService.getCompanyById(companyId) != null){
            if(companyService.getCompanyById(companyId) != null){
                Company company = companyService.getCompanyById(companyId);
                for(Review review : company.getReviews() ){
                    if (review.getRid().equals(rid)){
                        company.getReviews().remove(review);
                        review.setCompany(null); // to remove all references
                        companyService.updateCompany(company, companyId);
                        reviewRepository.delete(review);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
