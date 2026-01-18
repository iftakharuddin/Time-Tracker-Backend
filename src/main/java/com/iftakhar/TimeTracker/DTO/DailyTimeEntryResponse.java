package com.iftakhar.TimeTracker.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DailyTimeEntryResponse {

    private LocalDate date;
    private String projectName;
    private Double hours;

    public DailyTimeEntryResponse(LocalDate date, String projectName, Double hours) {
        this.date = date;
        this.projectName = projectName;
        this.hours = hours;
    }

    public DailyTimeEntryResponse() {
    }

    // getters
}