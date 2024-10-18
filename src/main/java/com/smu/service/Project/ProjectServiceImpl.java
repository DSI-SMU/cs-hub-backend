package com.smu.service.Project;

import com.smu.model.Project;
import com.smu.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService{


    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Add a new project
    @Override
    public Project addProject(Project project) {
        String acronym = getAcronym(project.getTitle());
        long count = projectRepository.countByTitleStartingWith(project.getTitle()) + 1;
        String id = String.format("%s-%03d", acronym, count);
        project.setId(id);
        return projectRepository.save(project);
    }

    private String getAcronym(String title) {
        String[] words = title.split(" ");
        StringBuilder acronym = new StringBuilder();
        if (words.length > 1) {
            for (String word : words) {
                if (!word.isEmpty()) {
                    acronym.append(word.charAt(0));
                }
            }
        } else {
            acronym.append(title.substring(0, Math.min(2, title.length())));
        }
        return acronym.toString().toUpperCase();
    }

    // Get all projects
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
