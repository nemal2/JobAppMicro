package com.nemal.JobAppMicro.review.repositories;

import com.nemal.JobAppMicro.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);


}
