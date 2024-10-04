package com.smu.controller;

import com.smu.model.Job;
import com.smu.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/add")
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job savedJob = jobService.addJob(job);
        return ResponseEntity.ok(savedJob);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
}
