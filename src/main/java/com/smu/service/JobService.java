package com.smu.service;



import com.smu.security.dto.RegistrationRequest;
import com.smu.utils.ExceptionMessageAccessor;
import com.smu.exceptions.RegistrationException;
import com.smu.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smu.model.Job;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class JobService {

    @Autowired
    private final JobRepository jobRepository;

    public List<Job> getAllJobs() {
        List<Job> allJobs = jobRepository.findAll();
        return allJobs;
    }

    public boolean deleteJobById(Long id) {
        if (jobExists(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
        // need to account for job not being found here

    }

    public Job getJobById(Long id) {
        if (jobExists(id)) {
            return jobRepository.findOneById(id);
        }
        else {
            // need to account for job not being found here
            return null;
        }

    }

    public boolean addJob(Job job) {
        return jobRepository.add(job);
    }

    public boolean jobExists(Long id) {
        return jobRepository.existsById(id);
    }

}
