package com.nemal.JobAppMicro.company.model;

import com.nemal.JobAppMicro.Job.Job;
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

    @OneToMany
    private List<Job> jobs;

    //private List<Review> reviews;

    public Company() {
    }
}
