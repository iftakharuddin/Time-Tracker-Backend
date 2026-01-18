package com.iftakhar.TimeTracker.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.iftakhar.TimeTracker.DTO.CreateTimeEntryRequest;
import com.iftakhar.TimeTracker.DTO.DailyTimeEntryResponse;
import com.iftakhar.TimeTracker.Entity.Project;
import com.iftakhar.TimeTracker.Entity.TimeEntry;
import com.iftakhar.TimeTracker.Repository.ProjectRepository;
import com.iftakhar.TimeTracker.Repository.TimeEntryRepository;

@Service
public class TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;
    private final ProjectRepository projectRepository;

    public TimeEntryService(TimeEntryRepository timeEntryRepository,
                            ProjectRepository projectRepository) {
        this.timeEntryRepository = timeEntryRepository;
        this.projectRepository = projectRepository;
    }

    // POST /api/time-entries
    public TimeEntry create(CreateTimeEntryRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        TimeEntry entry = new TimeEntry();
        entry.setDate(request.getDate());
        entry.setHours(request.getHours());
        entry.setProject(project);

        return timeEntryRepository.save(entry);
    }

    // GET daily
   public List<DailyTimeEntryResponse> getDaily(LocalDate date) {
    List<TimeEntry> entries = timeEntryRepository.findByDate(date);
    List<DailyTimeEntryResponse> responses = new ArrayList<>();

    for (TimeEntry e : entries) {
        responses.add(new DailyTimeEntryResponse(e.getDate(), e.getProject().getName(), e.getHours()));
    }

    return responses;
}


    // GET weekly
    public Map<LocalDate, Double> getWeekly(LocalDate start, LocalDate end) {
        return timeEntryRepository.findByDateBetween(start, end)
                .stream()
                .collect(Collectors.groupingBy(
                        TimeEntry::getDate,
                        Collectors.summingDouble(TimeEntry::getHours)
                ));
    }

    // GET monthly
    public Double getMonthlyTotal(LocalDate start, LocalDate end) {
        return timeEntryRepository.findByDateBetween(start, end)
                .stream()
                .mapToDouble(TimeEntry::getHours)
                .sum();
    }
}
