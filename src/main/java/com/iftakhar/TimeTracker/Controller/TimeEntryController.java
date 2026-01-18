package com.iftakhar.TimeTracker.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iftakhar.TimeTracker.DTO.CreateTimeEntryRequest;
import com.iftakhar.TimeTracker.DTO.DailyTimeEntryResponse;
import com.iftakhar.TimeTracker.Entity.TimeEntry;
import com.iftakhar.TimeTracker.Service.TimeEntryService;

@RestController
@CrossOrigin
@RequestMapping("/api/time-entries")
public class TimeEntryController {

    private final TimeEntryService service;

    public TimeEntryController(TimeEntryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(
            @RequestBody CreateTimeEntryRequest request) {

        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/daily")
    public ResponseEntity<List<DailyTimeEntryResponse>> daily(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return ResponseEntity.ok(service.getDaily(date));
    }

    @GetMapping("/weekly")
    public ResponseEntity<Map<LocalDate, Double>> weekly(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate weekStart) {

        LocalDate weekEnd = weekStart.plusDays(6);
        return ResponseEntity.ok(service.getWeekly(weekStart, weekEnd));
    }

    @GetMapping("/monthly")
    public ResponseEntity<Double> monthly(
            @RequestParam int year,
            @RequestParam int month) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        return ResponseEntity.ok(service.getMonthlyTotal(start, end));
    }
}
