package com.nemal.JobAppMicro.Job;

import com.nemal.JobAppMicro.Job.Job;

import java.util.List;

public interface JobService {

    void addJob(Job job);

    List<Job> findAll();

    Job findById(Long id);

    boolean deleteById(Long id);

    boolean updateJob(Long id, Job job);
}
