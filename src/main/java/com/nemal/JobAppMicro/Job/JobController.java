package com.nemal.JobAppMicro.Job;

import com.nemal.JobAppMicro.Job.impl.JobServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService ;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = jobService.findAll();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> addJob(@RequestBody Job job) {

        jobService.addJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id , @RequestBody Job updated) {
        boolean isUpdated = jobService.updateJob(id,updated);
        if(isUpdated){
        return new ResponseEntity<> ("Updated done", HttpStatus.OK);
    }
        else{
            return new ResponseEntity<>("Not found and not updated", HttpStatus.NOT_FOUND);
        }
    }


}
