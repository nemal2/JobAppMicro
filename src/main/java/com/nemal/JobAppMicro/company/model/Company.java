package com.nemal.JobAppMicro.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nemal.JobAppMicro.Job.Job;
import com.nemal.JobAppMicro.review.model.Review;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company() {
    }
}
