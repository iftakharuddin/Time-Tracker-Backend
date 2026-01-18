package com.iftakhar.TimeTracker.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Setter @Getter
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Boolean active = true;
}
