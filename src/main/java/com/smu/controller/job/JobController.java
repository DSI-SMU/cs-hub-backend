package com.smu.controller.job;

import com.smu.security.dto.*;
import com.smu.security.jwt.JwtTokenService;
import com.smu.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.smu.model.Job;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private final JobService jobService;

    private final JwtTokenService jwtTokenService;

    @PostMapping("/add")
    public boolean addJob(@Valid Job job) {
        return jobService.addJob(job);
    }
    @GetMapping("/listjobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/delete/{id}")
    public boolean deleteJob(@PathVariable Long id) {
        return jobService.deleteJobById(id);
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }



}
