package com.iftakhar.TimeTracker.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateTimeEntryRequest {

    private LocalDate date;
    private Double hours;
    private Long projectId;

    // getters & setters
}
