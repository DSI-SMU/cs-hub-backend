package com.smu.controller;

import com.smu.service.Project.ProjectServiceImpl;
import com.smu.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    // Controller for adding a new project
    @PostMapping("/add")
    public ResponseEntity<Project> createOrUpdateProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.addProject(project));
    }

    // Controller for getting all projects
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    // Get a project by id

    // Delete a project by id

}