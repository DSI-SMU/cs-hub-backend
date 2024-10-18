package com.smu.repository;

import com.smu.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository  extends  JpaRepository<Project, Long> {

    @Query("SELECT COUNT(p) FROM Project p WHERE p.title LIKE CONCAT(:title, '%')")
    long countByTitleStartingWith(String title);


}
