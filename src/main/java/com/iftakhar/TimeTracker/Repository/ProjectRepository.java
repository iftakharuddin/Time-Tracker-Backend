package com.iftakhar.TimeTracker.Repository;
import com.iftakhar.TimeTracker.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
