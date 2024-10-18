package com.smu.repository;

import com.smu.model.Job;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findAll();
    boolean add(Job job);
    Job deleteById(Long id);
    Job findOneById(Long id);


}
