package com.iftakhar.TimeTracker.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "time_entries")
public class TimeEntry {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private LocalDate date;
    private Double hours;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // No-args constructor
    public TimeEntry() {
    }

    // All-args constructor
    public TimeEntry(Long id, java.time.LocalDate date, Double hours, User user, Project project) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.user = user;
        this.project = project;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(java.time.LocalDate date) {
        this.date = date;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
