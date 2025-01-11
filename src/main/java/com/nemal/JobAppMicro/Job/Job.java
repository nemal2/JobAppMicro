package com.nemal.JobAppMicro.Job;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "job_table") // table name will be same as class name
@Data
@AllArgsConstructor

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nid;
    private String title;
    private String description;
    private String location;
    private String minSalary;
    private String maxSalary;

    @Version
    private int version;

//    public void setId(Long nid) {
//        this.nid = nid;
//    }
//
   //default constructor needed for JPA
    public Job() {
    }
//
//
//    public Long getId() {
//        return nid;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getMinSalary() {
//        return minSalary;
//    }
//
//    public void setMinSalary(String minSalary) {
//        this.minSalary = minSalary;
//    }
//
//    public String getMaxSalary() {
//        return maxSalary;
//    }
//
//    public void setMaxSalary(String maxSalary) {
//        this.maxSalary = maxSalary;
//    }
//
//    public Job(Long nid, String title, String description, String location, String minSalary, String maxSalary) {
//        this.nid = nid;
//        this.title = title;
//        this.description = description;
//        this.location = location;
//        this.minSalary = minSalary;
//        this.maxSalary = maxSalary;
//    }


}

