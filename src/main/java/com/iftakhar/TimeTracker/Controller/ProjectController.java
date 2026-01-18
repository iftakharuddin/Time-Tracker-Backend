package com.iftakhar.TimeTracker.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftakhar.TimeTracker.Entity.Project;
import com.iftakhar.TimeTracker.Repository.ProjectRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Project create(@RequestBody Project project) {
        return repository.save(project);
    }

    @GetMapping
    public List<Project> getAll() {
        return repository.findAll();
    }
}
