package com.nemal.JobAppMicro.Job;

import com.nemal.JobAppMicro.company.model.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "job_table") // table name will be same as class name
@AllArgsConstructor

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jid;
    private String title;
    private String description;
    private String location;
    private String minSalary;
    private String maxSalary;



    @ManyToOne
    private Company company;


   //default constructor needed for JPA
    public Job() {
    }
//

    public Long getJid() {
        return jid;
    }

    public void setJid(Long jid) {
        this.jid = jid;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }




    public Job(Long jid, String title, String description, String location, String minSalary, Company company, String maxSalary) {
        this.jid = jid;
        this.title = title;
        this.description = description;
        this.location = location;
        this.minSalary = minSalary;
        this.company = company;
        this.maxSalary = maxSalary;
    }

}

