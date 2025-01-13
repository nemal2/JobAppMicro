package com.nemal.JobAppMicro.review.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nemal.JobAppMicro.company.model.Company;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String title;
    private String description;
    private double rating;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonIgnore
    @ManyToOne
    private Company company;


    public Review() {
    }




    public Review(Long rid, String title, String description, double rating, Company company) {
        this.rid = rid;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.company = company;
    }



}
