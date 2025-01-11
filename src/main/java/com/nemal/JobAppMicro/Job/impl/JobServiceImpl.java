package com.nemal.JobAppMicro.Job.impl;

import com.nemal.JobAppMicro.Job.Job;
import com.nemal.JobAppMicro.Job.JobRepository;
import com.nemal.JobAppMicro.Job.JobService;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImpl implements JobService {

    private Long nid = 1L;
    @Autowired
    private JobRepository jobRepository;


    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    //private List<Job> jobs = new ArrayList<Job>();

    @Override
    public void addJob(Job job) {

        try {
            jobRepository.save(job);
        } catch (Exception e) {
            throw new RuntimeException("Job update conflict. Please try again.", e);
        }
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findById(Long id) {

        return jobRepository.findById(id).orElse(null);

    }

    @Override
    public boolean deleteById(Long id) {
        try  {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
}

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional <Job> jobx = jobRepository.findById(id);
        //Job job11 = job1.get();
        if (jobx.isPresent())
             { Job job1 = jobx.get();
                job1.setTitle(job.getTitle());
                job1.setDescription(job.getDescription());
                job1.setLocation(job.getLocation());
                job1.setMinSalary(job.getMinSalary());
                job1.setMaxSalary(job.getMaxSalary());
                jobRepository.save(job1);
                return true;
            }

        return false;
    }
}
